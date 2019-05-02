package mlg.blockchain;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.jline.PromptProvider;
import mlg.blockchain.model.Miner;
import mlg.blockchain.shell.MinerCli;

import java.util.ArrayList;

import static java.util.Objects.isNull;

@SpringBootApplication
@ComponentScan(basePackages = {"mlg.blockchain"})
public class MinerApplication {

    public static void main(String[] args)  throws Exception {
        if (isNull(args) || args.length <3)
            throw new IllegalArgumentException("The name, ip and port are mandatory inputs.");

        Miner miner = Miner.builder()
                .name(args[0])
                .address(args[1])
                .difficulty(1)
                .port(Integer.valueOf(args[2]))
                .build();
                
        MinerCli.setMiner(miner);
        MinerCli.start();
        SpringApplication.run(MinerApplication.class, args);
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString(MinerCli.getMiner().id()+"$ ", AttributedStyle.DEFAULT.foreground(AttributedStyle.YELLOW));
    }
}


