#!/bin/sh
set -e
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. $PWD/common.sh
sh localbuild.sh
#ansible will judge if no such folder, create it
ansible-copy "src=../target/dummyServer-0.1.jar dest=/home/vagrant/InstallSave/"
ansible-copy "src=../config/hello.yaml dest=/home/vagrant/InstallSave/"
ansible-copy "src=../config/start.sh dest=/home/vagrant/InstallSave/"
ansible-copy "src=../config/stop.sh dest=/home/vagrant/InstallSave/"
ansible-cmd "sh /home/vagrant/InstallSave/stop.sh"
ansible-cmd "nohup sh /home/vagrant/InstallSave/start.sh &"
