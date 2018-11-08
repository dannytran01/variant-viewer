#!/usr/bin/env bash

echo '*****************************'
echo '**Installing Variant-Viewer**'
echo '*****************************'

echo 'This will take some time'

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null && pwd )"

# Generate dependencies
${DIR}/sbt clean stage

echo '*****************************'
echo '** Finished installation  ***'
echo '*****************************'
