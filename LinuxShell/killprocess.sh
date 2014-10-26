#!/bin/sh
#two samples kill firefox by ps name

ps -auwx|grep firefox|grep -v grep|tr -s ' '|cut -f2 -d ' '|xargs kill -9

pgrep firefox|xargs kill -9
