#!/usr/bin/env bash

echo '*****************************'
echo '** Starting Variant-Viewer **'
echo '*****************************'

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

PID_FILE="${DIR}/target/universal/stage/RUNNING_PID"

if [[ -f ${PID_FILE} ]]
then
    echo ${PID_FILE} was found. Application is already running.
    exit 1
fi

nohup ${DIR}/target/universal/stage/bin/variant-viewer -Dplay.http.secret.key='[vc/eM^G51TcvGnTlVV[u1DLY78xTuH`r56VyTTgsq1JDcosl:Cz2LakguQYNx4c' &

echo 'Ready to run on localhost:9000'