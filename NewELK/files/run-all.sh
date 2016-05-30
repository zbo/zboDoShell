#!/usr/bin/env bash
echo "start elastic search deamon"
nohup sh /usr/share/elasticsearch/bin/elasticsearch --cluster.name cluster_name --node.ne node_name --network.host 192.168.33.13 >/home/vagrant/elastic.log &
echo "start logstash deamon"
nohup /opt/logstash/bin/logstash -f logstash.conf >/home/vagrant/logstash.log &
echo "start kibana"
nohup /home/vagrant/InstallSave/ELK/kibana-4.5.1-linux-x64/bin/kibana >/home/vagrant/kibana.log &