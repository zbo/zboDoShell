#!/bin/bash
#
#copy ruby zip to InstallSave/ruby
#unzip ruby
#
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${PWD}/../common.sh
#ansible-copy "src=/Users/twer/project/Software/ruby-1.9.3-p0.tar.gz dest=/home/vagrant/InstallSave/Ruby/"
#ansible-cmd "cd /home/vagrant/InstallSave/Ruby/&&tar -zxvf ruby-1.9.3-p0.tar.gz"

ansible-copy "src=/Users/twer/project/Software/elasticsearch-1.4.0.tar.gz dest=/home/vagrant/InstallSave/ElasticSearch/"
ansible-cmd "cd /home/vagrant/InstallSave/ElasticSearch/&&tar -zxvf elasticsearch-1.4.0.tar.gz"
ansible-copy "src=/Users/twer/project/Software/kibana-3.1.0.zip dest=/home/vagrant/InstallSave/Kibana/"
ansible-cmd "cd /home/vagrant/InstallSave/Kibana/&&unzip kibana-3.1.0.zip"