#!/bin/bash
ps -auwx|grep dummy|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
do
   kill -9 $line
done