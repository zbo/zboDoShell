#!/bin/sh
echo "start elastic search deamon"
cd /home/vagrant/InstallSave/LogView/ElasticSearch/elasticsearch-1.1.1/bin/
ps auwx|grep elastic|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
do
   kill -9 $line
done
rm -rf nohup.out
nohup sh ./elasticsearch &