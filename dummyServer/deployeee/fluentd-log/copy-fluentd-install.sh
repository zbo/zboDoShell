#!/bin/bash
#
#scp this script into any folder, run it will download td-agent and install
#
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${PWD}/../common.sh

ansible-copy "src=./installtd.sh dest=/home/vagrant/InstallSave/fluentd/"