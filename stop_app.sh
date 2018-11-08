#!/usr/bin/env bash

echo '*****************************'
echo '** Stopping Variant-Viewer **'
echo '*****************************'

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"
PID_FILE="${DIR}/target/universal/stage/RUNNING_PID"

if [[ ! -f ${PID_FILE} ]]
then
    echo ${PID_FILE} was not found. Application may not be running.
    exit 1
fi

pid=`cat ${PID_FILE}`

kill ${pid}
