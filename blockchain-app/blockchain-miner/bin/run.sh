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

#rm spring-shell.log &
echo "Running ./run.sh $1 $2 $3"

#mvn clean install
java -jar target/blockchain-miner-0.0.1-SNAPSHOT.jar $1 $2 $3