#!/usr/bin/env bash
echo "start elastic search deamon"
#cd
#ps auwx|grep elastic|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
#do
#   kill -9 $line
#done
nohup sh /usr/share/elasticsearch/bin/elasticsearch --cluster.name cluster_name --node.ne node_name --network.host 192.168.33.13 >/home/vagrant/elastic.log &