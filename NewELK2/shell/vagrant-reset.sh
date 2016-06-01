#!/usr/bin/env bash
cd /home/zbo/Downloads/vmdisks/VM2
vagrant destroy -f
vagrant up
cd /home/zbo/Downloads/vmdisks/VM3
vagrant destroy -f
vagrant up
cd /home/zbo/Downloads/vmdisks/VMELK
vagrant destroy -f
vagrant up