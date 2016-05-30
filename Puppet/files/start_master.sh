#!/usr/bin/env bash
nohup puppet master --verbose --no-daemonize >>master.log 2>&1 &
