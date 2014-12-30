#!/bin/bash
#
#copy jdk rpm to InstallSave
#call yum moudle install java
#
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. $PWD/../common.sh
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
ansible-copy "src=/Users/twer/project/Software/td-agent-2.1.1-0.x86_64.rpm dest=/home/vagrant/InstallSave/"
ansible-playbook -i ${PWD}/../hosts -sudo ${PWD}/td-agent.yaml

