#!/usr/bin/env bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
# hosts be defined in ansible.cfg
ansible-playbook mysql_install.yml