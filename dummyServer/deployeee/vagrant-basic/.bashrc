# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
        . /etc/bashrc
fi

# User specific aliases and functions
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. ${PWD}/init-env.sh