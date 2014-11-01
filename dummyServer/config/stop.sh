#!/bin/bash
ps -auwx|grep dummy|grep -v grep|tr -s ' '|cut -f2 -d ' '|xargs kill -9