# bitcoin-regtest-box
Create your own private bitcoin regtest with 2 nodes

# With docker
`docker build -t bitcoin/regtest:v1 .`

 `docker run -t -i -p 8081:8081 -p 8091:8091 -p 8082:8082  -p 8092:8092  bitcoin/regtest:v1`

# Without docker
You must have `bitcoind` and `bitcoin-cli` installed on your system and in the path 
- tar the file dstribution into the bitcoin folder and add the bin folder into the path


## Starting regtest 
This will start up two nodes using the two datadirs `1` and `2`. They
will only connect to each other in order to remain an isolated private regtest.
Two nodes are provided, as one is used to generate blocks and it's balance
will be increased.

Node `1` will listen on port `8081`, allowing node `2` to connect to it. With `8091` for the JSON-RPC server.

Node `2` will listen on port `8082` and will listen on port `8092`  for the JSON-RPC server.

Both nodes are sincronized.

```
$ make start
```

## Check the status of the nodes

```
$ make getinfo
bitcoin-cli -datadir=1  getinfo
{
    "version" : 90300,
    "protocolversion" : 70002,
    "walletversion" : 60000,
    "balance" : 0.00000000,
    "blocks" : 0,
    "timeoffset" : 0,
    "connections" : 1,
    "proxy" : "",
    "difficulty" : 0.00000000,
    "testnet" : false,
    "keypoololdest" : 1413617762,
    "keypoolsize" : 101,
    "paytxfee" : 0.00000000,
    "relayfee" : 0.00001000,
    "errors" : ""
}
bitcoin-cli -datadir=2  getinfo
{
    "version" : 90300,
    "protocolversion" : 70002,
    "walletversion" : 60000,
    "balance" : 0.00000000,
    "blocks" : 0,
    "timeoffset" : 0,
    "connections" : 1,
    "proxy" : "",
    "difficulty" : 0.00000000,
    "testnet" : false,
    "keypoololdest" : 1413617762,
    "keypoolsize" : 101,
    "paytxfee" : 0.00000000,
    "relayfee" : 0.00001000,
    "errors" : ""
}
```

## Generating blocks

Normally on the live, real, bitcoin network, blocks are generated, on average,
every 10 minutes. Since this regtest uses Bitcoin Core's (bitcoind), 
we are able to generate a block on a private network instantly using a simple command.

To generate a block in node1: 

```
$ make generate1
```

To generate a block in node2: 

```
$ make generate2
```

To generate more than 1 block:

```
$ make generateX BLOCKS=10
```

## Need to generate at least 100 blocks before there will be a balance in the first wallet
```
$ make generateX BLOCKS=200
```

## Verify that there is a balance on the first wallet
```
$ make getinfo
```

## Generate a wallet address for the second wallet
```
$ make address2
```

## Sending bitcoins
To send bitcoins that you've generated to the second wallet: (be sure to change the ADDRESS value below to wallet address generated in the prior command)

```
$ make sendfrom1 ADDRESS=mxwPtt399zVrR62ebkTWL4zbnV1ASdZBQr AMOUNT=10
```

## Does the balance show up?
Run the getinfo command again. Does the balance show up? Why not?
```
$ make getinfo
```

## Generate another block
```
$ make generate
```

## Stopping the testnet-box

```
$ make stop
```

To clean up any files created while running the testnet and restore to the
original state:

```
$ make clean
```

## Using with docker
This testnet-box can be used with [Docker](https://www.docker.com/) to run it in
an isolated container.

## If We have NodeJs installed
If Node js is installed. We can install easilly one bitcoin explorer
```
$ make installExplorer
```

Then We can run the explorer (PORT ) and set one of the bitcoin nodes
```
$ make startWeb
```




### Building docker image

Build it yourself from this directory
  * `docker build -t bitcoin/regtest:v1 .`

### Running docker container
The docker image will run two bitcoin nodes in the background and is meant to be
attached to allow you to type in commands. The image also exposes
the two JSON-RPC ports from the nodes if you want to be able to access them
from outside the container.
      
   `docker run -t -i -p 8081:8081 -p 8091:8091 -p 8082:8082  -p 8092:8092 -p 8085:8085 bitcoin/regtest:v1`

Also there is a bitcoin explorer available at 
   * `http://localhost:8085`
