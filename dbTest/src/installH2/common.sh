#!/bin/bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
alias ansible-cmd="ansible vag -i ${PWD}/hosts -m shell -a"
alias ansible-cmd-sudo="ansible --sudo vag -i ${PWD}/hosts -m shell -a"
alias ansible-copy="ansible vag -i ${PWD}/hosts -m copy -a"
alias ansible-copy-sudo="ansible --sudo vag -i ${PWD}/hosts -m copy -a"
