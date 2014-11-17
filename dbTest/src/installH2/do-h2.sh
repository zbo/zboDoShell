#!/bin/bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${PWD}/common.sh
ansible-copy "src=/Users/twer/project/Software/h2-1.4.182.jar dest=/home/vagrant/InstallSave/H2/"
ansible-copy "src=${PWD}/start.sh dest=/home/vagrant/InstallSave/H2/"
ansible-cmd "cd /home/vagrant/InstallSave/H2/&&nohup sh ./start.sh &"