#!/bin/bash
#
#copy jdk rpm to InstallSave
#call yum moudle install java
#
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. $PWD/common.sh
ansible-copy "src=/Users/twer/project/Software/jdk-7u17-linux-x64.rpm dest=/home/vagrant/InstallSave/"
ansible-playbook -i ./hosts -sudo ./require-java/java.yaml

