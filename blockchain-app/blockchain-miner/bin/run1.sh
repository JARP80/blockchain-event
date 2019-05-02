#!/usr/bin/env bash

java -jar  -agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=y target/blockchain-miner-0.0.1-SNAPSHOT.jar m1 localhost 3011