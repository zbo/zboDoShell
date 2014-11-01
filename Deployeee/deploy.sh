#!/bin/sh
ansible vag -i ./hosts -m shell -a "ls"
