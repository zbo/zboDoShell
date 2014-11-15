#!/bin/bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${PWD}/../common.sh
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
ansible-copy "src=${PWD}/.bashrc dest=/home/vagrant/"
ansible-copy "src=${PWD}/init-env.sh dest=/home/vagrant/"
ansible-cmd-sudo "chmod 775 /home/vagrant"