#!/usr/bin/env bash

function errorMessage (){
        echo "";
        echo "=========ERROR=============";
        echo "Usage: $0 miner-name miner-ip miner-port";
        echo "==================";
        echo "";
        exit 1;
}
if (( $# < 3  )); then
        errorMessage
fi

mvn clean install
echo "Debug ./debug.sh $1 $2 $3"
java -agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=y -jar target/blockchain-miner-0.0.1-SNAPSHOT.jar $1 $2 $3