#!/usr/bin/env bash
ps auwx|grep elastic|grep -v grep|tr -s ' '|cut -f2 -d ' '|xargs kill -9
ps auwx|grep logstash|grep -v grep|tr -s ' '|cut -f2 -d ' '|xargs kill -9
ps auwx|grep kibana|grep -v grep|tr -s ' '|cut -f2 -d ' '|xargs kill -9