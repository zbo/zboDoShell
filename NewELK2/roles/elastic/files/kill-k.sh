#!/usr/bin/env bash
#kill -9  $(ps -ef | grep "kibana" |grep -v grep| awk '{print $2}')

ps auwx|grep kibana|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
do
   kill -9 $line
done