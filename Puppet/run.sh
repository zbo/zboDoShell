#!/bin/bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"


ansible-playbook -i hosts PuppetVM1.yaml
ansible-playbook -i hosts PuppetVM2.yaml
