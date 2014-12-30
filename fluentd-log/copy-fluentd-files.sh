#!/bin/bash
#copy td-agent conf file and test file

PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${PWD}/../common.sh
ansible-copy "src=${PWD}/fluentd-log/test-td-agent.sh dest=/home/vagrant/InstallSave/fluentd/"
ansible-copy-sudo "src=${PWD}/fluentd-log/td-agent.conf dest=/etc/td-agent/"