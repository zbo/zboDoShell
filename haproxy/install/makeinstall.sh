#!/bin/sh

cd /home/vagrant/InstallSave/Haproxy/haproxy-1.4.17
make TARGET=linux2628 USE_LINUX_TPROXY=1 PREFIX=/usr/local/haproxy14
make install PREFIX=/usr/local/haproxy14
