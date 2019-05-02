package mlg.blockchain.shell;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import mlg.blockchain.model.common.HashNonce;
import mlg.blockchain.model.MinerId;
import mlg.blockchain.model.Miner;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static mlg.blockchain.config.EncryptService.getMessageDigest;

@Slf4j
public final class MinerService {

    private static boolean listening = false;

    private MinerService(){}

    public static boolean start(final Miner miner, final ServerSocket serverSocket) {
        
        return listening;
    }

    public static void generateGenesisBlock(Miner miner, String data) throws JsonProcessingException {
       
    }

    public static void generateBlock(Miner miner, String data) throws JsonProcessingException {
       
    }

    private static void calculateHashForBlock(final Miner miner, final Object block) throws JsonProcessingException {
        

    }

    public static HashNonce simulateCreateHash(String data) {
       return null;
    }

    private static String calculateHash(String fromData) {

        // use MessageDigest
        return null;
    }


    public static boolean stop(final Miner miner, final ServerSocket serverSocket) {
        
        return false;
    }

    public static void addAndBroadcastNewBlock(final Miner miner, Object creator, Object block) {
         
    }

    public static void addBlock(final Miner miner, Object block) {

    }

    public static boolean isChainValid(final Miner miner) throws Exception {
        
        return true;
    }

    public static MinerId addPeer(final Miner miner, MinerId minerId, boolean sincronize) {
        return null;
    }


    public static void deletePeer(Miner miner, MinerId peer){
        
    }

    

    public static Object getMinerInfo(final Miner miner) {
        return null;
    }


}
