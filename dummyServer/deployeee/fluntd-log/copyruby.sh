#!/bin/bash
#
#copy ruby zip to InstallSave/ruby
#unzip ruby
#
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${PWD}/../common.sh
#ansible-copy "src=/Users/twer/project/Software/ruby-1.9.3-p0.tar.gz dest=/home/vagrant/InstallSave/Ruby/"
#ansible-cmd "cd /home/vagrant/InstallSave/Ruby/&&tar -zxvf ruby-1.9.3-p0.tar.gz"

ansible-copy "src=./installtd.sh dest=/home/vagrant/InstallSave/Ruby/"