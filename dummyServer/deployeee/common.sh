#!/bin/bash
alias ansible-cmd="ansible vag -i ./hosts -m shell -a"
alias ansible-copy="ansible vag -i ./hosts -m copy -a"