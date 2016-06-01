#!/usr/bin/env bash
#ps auwx|grep logstash|grep -v grep|tr -s ' '|cut -f2 -d ' '|xargs kill -9 &&

kill -9  $(ps -ef | grep "elastic" |grep -v grep| awk '{print $2}')