#!/bin/bash
PWD="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
. $PWD/common.sh
cd $dummyServerCodeHome
mvn package