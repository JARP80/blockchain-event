package mlg.blockchain.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@ToString
@Builder
@Data
public class Miner implements Serializable {

    private String name;
    private String address;
    private int port;
    private int difficulty;

    public MinerId id() {
        return new MinerId(this.name, this.address, this.port);
    }

}
