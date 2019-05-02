package mlg.blockchain.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import mlg.blockchain.model.Miner;
import mlg.blockchain.model.MinerId;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static mlg.blockchain.config.JacksonConfiguration.toJson;

@ShellComponent
public class MinerCli  {

    private static Miner miner;

    public static void setMiner(Miner miner) {
        MinerCli.miner = miner;
    }

    public static Miner getMiner() {
        return miner;
    }

    public static String start()  throws Exception {
        return miner.id()+ " -  started";
    }

    @ShellMethod(value = "Stop the miner.")
    public void stop()  throws Exception {
        System.out.println(miner.id()+ " stoped");
        System.exit(0);
    }

    @ShellMethod(value = "Simulate the hash creation the miner.")
    public String hash(String data)  throws Exception {
        return MinerService.simulateCreateHash(data).toJson();
    }

    @ShellMethod(value = "Check the difficulty in the miner..")
    public String difficulty()  throws Exception {
        return null;
    }

    @ShellMethod(value = "Set the difficulty in the miner..")
    public String setdifficulty(int difficulty)  throws Exception {
        return null;
    }

    @ShellMethod(value = "Get blockchain.")
    public String blockchain()  throws Exception {
        return null;
    }


    @ShellMethod(value = "Create a new block and broadcast to the peers...")
    public String createblock(@ShellOption String data)  throws Exception {
        return null;
    }

    @ShellMethod(value = "Create a genesis block for the miner..")
    public String genesisblock(@ShellOption String data)  throws Exception {
        return null;
    }



   


}