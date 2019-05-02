package mlg.blockchain.model.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.Serializable;

import static mlg.blockchain.config.JacksonConfiguration.getObjectMapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HashNonce implements Serializable {

    private String hash;
    private int nonce;

    public static HashNonce fromJson(String json) throws IOException {
        return getObjectMapper().readValue(json, HashNonce.class);
    }

    public String toJson() throws JsonProcessingException {
        return getObjectMapper().writeValueAsString(this);
    }
}
