#!/bin/bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${PWD}/common.sh
#copy binary files
LOCALSOFT=/Users/twer/project/Software
VAGRANTLOGVIEW=/home/vagrant/InstallSave/LogView
#ansible-file "path=${VAGRANTLOGVIEW}/Logstash/ state=directory"
#ansible-unarchive "src=${LOCALSOFT}/logstash-1.4.2.tar.gz dest=${VAGRANTLOGVIEW}/Logstash/"
#ansible-file "path=${VAGRANTLOGVIEW}/ElasticSearch/ state=directory"
#ansible-unarchive "src=${LOCALSOFT}/elasticsearch-1.1.1.tar.gz dest=${VAGRANTLOGVIEW}/ElasticSearch/"
#ansible-file "path=${VAGRANTLOGVIEW}/Kibana/ state=directory"
#ansible-unarchive "src=${LOCALSOFT}/kibana-3.1.0.zip dest=${VAGRANTLOGVIEW}/Kibana/"

#copy start script and config files
#ansible-copy "src=${PWD}/logstash/myconfig.conf dest=${VAGRANTLOGVIEW}/Logstash/logstash-1.4.2/bin/"
#ansible-copy "src=${PWD}/logstash/start-logstash.sh dest=${VAGRANTLOGVIEW}/Logstash/logstash-1.4.2/bin/"
#ansible-copy "src=${PWD}/elasticsearch/start-elastic.sh dest=${VAGRANTLOGVIEW}/ElasticSearch"
#ansible-file-sudo "path=/var/www/html/kibana/ state=directory"
#ansible-cmd-sudo "cp -r ${VAGRANTLOGVIEW}/Kibana/kibana-3.1.0/* /var/www/html/kibana/"
#ansible-copy-sudo "src=${PWD}/kibana/config.js dest=/var/www/html/kibana/"
#
#start elastic search
#start logstash
#ansible-cmd "sh /home/vagrant/killmine.sh"
ansible-cmd "nohup sh /home/vagrant/InstallSave/LogView/ElasticSearch/elasticsearch-1.1.1/bin/elasticsearch &"
ansible-cmd "nohup sh /home/vagrant/InstallSave/LogView/Logstash/logstash-1.4.2/bin/start-logstash.sh &"