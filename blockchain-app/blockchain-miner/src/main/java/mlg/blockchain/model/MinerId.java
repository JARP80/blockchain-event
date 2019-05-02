package mlg.blockchain.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;

import static mlg.blockchain.config.JacksonConfiguration.getObjectMapper;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MinerId implements Serializable {

    private String id;

    public MinerId(String name, String address, int port) {
        this.id = name+":"+address+":"+port;
    }

    public String getName(){
        return this.id.split(":")[0];
    }


    public String getAddress(){
        return this.id.split(":")[1];
    }

    public int getPort(){
        return Integer.valueOf(this.id.split(":")[2]);
    }

    public static MinerId fromJson(String json) throws IOException {
        return getObjectMapper().readValue(json, MinerId.class);
    }

    public String toJson() throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(this);
    }
}
