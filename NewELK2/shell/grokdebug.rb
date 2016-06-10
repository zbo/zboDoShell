require 'rubygems'
require 'grok-pure'
require 'optparse'
require 'ap'
options = {}
ARGV.push('-h') if ARGV.size === 0
OptionParser.new do |opts|
  opts.banner = 'Run grokdebug at your terminal.'
  options[:dirs] = %w(patterns)
  options[:named] = false
  opts.on('-d DIR1,DIR2', '--dirs DIR1,DIR2', Array, 'Set grok patterns directories. Default: "./patterns"') do |value|
    options[:dirs] = value
  end
  opts.on('-m MESSAGE', '--msg MESSAGE', 'Your raw message to be matched') do |value|
    options[:message] = value
  end
  opts.on('-p PATTERN', '--pattern PATTERN', 'Your grok pattern to be compiled') do |value|
    options[:pattern] = value
  end
  opts.on('-n', '--named', 'Named captures only') do
    options[:named] = true
  end
end.parse!
grok = Grok.new
options[:dirs].each do |dir|
  if File.directory?(dir)
    dir = File.join(dir, "*")
  end
  Dir.glob(dir).each do |file|
    grok.add_patterns_from_file(file)
  end
end
grok.compile(options[:pattern], options[:named])
ap grok.match(options[:message]).captures()
