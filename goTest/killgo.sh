#!/bin/bash
ps auwx|grep go-server|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
do
   kill -9 $line
done
ps auwx|grep go-agent|grep -v grep|tr -s ' '|cut -f2 -d ' '|while read line
do
   kill -9 $line
done