#!/bin/bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. $PWD/../common.sh
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
ansible-cmd-sudo "/etc/init.d/td-agent restart"
