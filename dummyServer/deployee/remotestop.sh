#!/bin/bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. $PWD/common.sh
ansible-cmd "sh /home/vagrant/InstallSave/stop.sh"