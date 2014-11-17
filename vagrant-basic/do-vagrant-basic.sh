#!/bin/bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${PWD}/common.sh
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
ansible-copy "src=${PWD}/require-vagrant/.bashrc dest=/home/vagrant/"
ansible-copy "src=${PWD}/require-vagrant/init-env.sh dest=/home/vagrant/"
ansible-copy "src=${PWD}/require-vagrant/killmine.sh dest=/home/vagrant/"
ansible-copy "src=${PWD}/require-vagrant/startlog.sh dest=/home/vagrant/"
ansible-copy-sudo "src=${PWD}/require-vagrant/hosts dest=/etc/"
ansible-cmd-sudo "chmod 775 /home/vagrant"