#!/bin/bash
#
#copy jdk rpm to InstallSave
#call yum moudle install java
#
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. $PWD/common.sh
ansible-copy "src=/Users/twer/project/Software/httpd-2.2.15-39.el6.centos.x86_64.rpm dest=/home/vagrant/InstallSave/"
ansible-playbook -i ./hosts -sudo ./require-httpd/httpd.yaml

