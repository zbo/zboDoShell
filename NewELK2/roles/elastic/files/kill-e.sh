#!/usr/bin/env bash
#ps auwx|grep logstash|grep -v grep|tr -s ' '|cut -f2 -d ' '|xargs kill -9 &&

#kill -9  $(ps -ef | grep "elastic" |grep -v| awk '{print $2}')

ps auwx|grep elastic|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
do
   kill -9 $line
done