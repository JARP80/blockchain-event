BITCOIND=bitcoind
BITCOINGUI=bitcoin-qt
BITCOINCLI=bitcoin-cli
B1_FLAGS=
B2_FLAGS=
STARTB1=-conf=bitcoin.conf -port=8081 -rpcport=8091 -addnode=127.0.0.1:8082 -datadir=1 $(B1_FLAGS)
STARTB2=-conf=bitcoin.conf -port=8082 -rpcport=8092 -addnode=127.0.0.1:8081 -datadir=2 $(B2_FLAGS)
B1=-conf=bitcoin.conf -rpcport=8091 -datadir=1 $(B1_FLAGS)
B2=-conf=bitcoin.conf -rpcport=8092 -datadir=2 $(B2_FLAGS)
BLOCKS=1
ADDRESS=
AMOUNT=
ACCOUNT=
TXID=

start:
	$(BITCOIND) $(STARTB1) -daemon
	$(BITCOIND) $(STARTB2) -daemon

start1:
	$(BITCOIND) $(STARTB1) -daemon

start2:
	$(BITCOIND) $(STARTB2) -daemon	

startAll:
	$(BITCOIND) $(STARTB1) -daemon
	$(BITCOIND) $(STARTB2) -daemon
	make startWeb

generate1:
	$(BITCOINCLI) $(B1) generate $(BLOCKS)

generate2:
	$(BITCOINCLI) $(B2) generate $(BLOCKS)

getinfo:
	$(BITCOINCLI) $(B1) -getinfo
	$(BITCOINCLI) $(B2) -getinfo

getblockchaininfo:
	$(BITCOINCLI) $(B1) getblockchaininfo
	$(BITCOINCLI) $(B2) getblockchaininfo

getnetworkinfo:
	$(BITCOINCLI) $(B1) getnetworkinfo
	$(BITCOINCLI) $(B2) getnetworkinfo

getwalletinfo:
	$(BITCOINCLI) $(B1) getwalletinfo
	$(BITCOINCLI) $(B2) getwalletinfo
	
getpeerinfo:
	$(BITCOINCLI) $(B1) getpeerinfo
	$(BITCOINCLI) $(B2) getpeerinfo	

sendfrom1:
	$(BITCOINCLI) $(B1) sendtoaddress $(ADDRESS) $(AMOUNT)

sendfrom2:
	$(BITCOINCLI) $(B2) sendtoaddress $(ADDRESS) $(AMOUNT)

address1:
	$(BITCOINCLI) $(B1) getnewaddress $(ACCOUNT)

address2:
	$(BITCOINCLI) $(B2) getnewaddress $(ACCOUNT)

getblock:
	$(BITCOINCLI) $(B1) getblock $(BLOCKHASH)

gettransaction:
	$(BITCOINCLI) $(B2) gettransaction $(TXID)


stop:
	$(BITCOINCLI) $(B1) stop
	$(BITCOINCLI) $(B2) stop

clean:
	rm -rf ./1/regtest
	rm -rf ./1/blocks
	rm -rf ./2/regtest
	rm -rf ./2/blocks