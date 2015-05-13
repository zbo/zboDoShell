#!/bin/bash
ps auwx|grep java|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
do
   kill -9 $line
done