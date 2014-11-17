#!/bin/bash
ps auwx|grep elastic|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
do
   kill -9 $line
done
ps auwx|grep logstash|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
do
   kill -9 $line
done
