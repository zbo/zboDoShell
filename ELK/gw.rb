# encoding: utf-8
require "logstash/filters/base"
require "logstash/namespace"
require "logstash/environment"
require "set"

class LogStash::Filters::Gw < LogStash::Filters::Base

  config_name "gw"
  milestone 3

  # The regular expression to match.

  # Detect if we are running from a jarfile, pick the right path.
  @@patterns_path = Set.new
  @@patterns_path += [LogStash::Environment.pattern_path("*")]

  public
  def initialize(config = {})
    super

    @threadsafe = false

    # This filter needs to keep state.
    @types = Hash.new { |h,k| h[k] = [] }
    @pending = nil
  end # def initialize

  public
  def register
    require "grok-pure" # rubygem 'jls-grok'


    @logger.debug("Registered multiline plugin", :type => @type, :config => @config)
  end # def register


# gwtran.log.27000407:[140127000222.969.892][TC02:16566]tradecode [7180] sub tradecode [NULL]
# gwtran.log.27000407:[140127000222.970.038][TC02:16566]ARK_MatchDdr
# gwtran.log.27000407:[140127000222.970.048][TC02:16566][ddr.c:1450]数据依赖路由选择...
# gwtran.log.27000407:[140127000222.970.109][TC02:16566][ddr.c:1580]search trcd...
# gwtran.log.27000407:[140127000222.970.794][TC02:16566][ddr.c:1606]通过标志域数据依赖路由没有选择结果
# gwtran.log.27000407:[140127000222.970.821][TC02:16566][ddr.c:1547]数据依赖路由选择结果[00000001]
# gwtran.log.27000407:[140127000222.970.825][TC02:16566][ddr.c:2247]查找Tpp结构...
# gwtran.log.27000407:[140127000222.970.836][TC02:16566]tcpOpen [RUNSERVER][0][120]!
# gwtran.log.27000407:[140127000222.970.863][TC02:16566]
# gwtran.log.27000407:[140127000222.970.963][TC02:16566]send pre deal
# gwtran.log.27000407:[140127000222.973.259][TC02:16566]
# gwtran.log.27000407:[140127000222.973.377][TC02:16566]my tpcall 
# gwtran.log.27000407:[140127000223.483.012][TC02:16566]Can't send request to service [RUNSERVER] error [10]
# gwtran.log.27000407:[140127000223.485.896][TC02:16566]my tpcall  finish  [272]
# gwtran.log.27000407:[140127000223.485.913][TC02:16566]child : recv finish
# gwtran.log.27000407:[140127000223.485.917][TC02:16566]child : end recv end deal
# gwtran.log.27000407:[140127000223.486.001][TC02:16566]send msg to gtm ok



  public
  def filter(event)
    return unless filter?(event)
    tmp = event.to_hash
    @logger.debug(tmp)
    if tmp['mes'] =~ /^tradecode/
      @pending = Hash.new
      @logger.debug("===============================")
      @logger.debug(tmp['mes'].scan(/\[(.*)\]/))
      @pending['tradecode'] = tmp['tid'].gsub!(':',"_") + "_" + tmp['mes'].match(/\[(.+?)\]/)[1]
      @pending['lines'] = []
    end
    if tmp['mes'] == "send msg to gtm ok" || tmp['mes'] == "Can't send request to service"
      # @logger.debug("Registered multiline plugin", :type => @type, :config => @config)
      tmp.merge!(@pending)
      event_new = LogStash::Event.new(tmp)
      event.overwrite(event_new)
      @pending = nil
    end
    if @pending then
      @pending['lines'] << (tmp['mes'])
      event.cancel
    end
    
  end # def filter

  # Flush any pending messages. This is generally used for unit testing only.
  #
  # Note: flush is disabled now; it is preferable to use the multiline codec.

end # class LogStash::Filters::Multiline
