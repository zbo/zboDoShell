#!/bin/sh
echo "start logstash"
sh /home/vagrant/InstallSave/LogView/Logstash/logstash-1.4.2/bin/logstash -f /home/vagrant/InstallSave/LogView/Logstash/logstash-1.4.2/bin/myconfig.conf

