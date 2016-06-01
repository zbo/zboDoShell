#!/usr/bin/env bash
#kill -9  $(ps -ef | grep "kibana" |grep -v grep| awk '{print $2}')
nohup sh /home/vagrant/InstallSave/ELK/kibana-4.5.1-linux-x64/bin/kibana >>/home/vagrant/kibana.log 2>&1 &