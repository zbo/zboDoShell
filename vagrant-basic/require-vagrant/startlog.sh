#!/bin/bash
cd /home/vagrant/InstallSave/LogView/ElasticSearch/elasticsearch-1.1.1/bin/
nohup sh start-elastic.sh &
cd /home/vagrant/InstallSave/LogView/Logstash/logstash-1.4.2/bin/
nohup sh start-logstash.sh &
