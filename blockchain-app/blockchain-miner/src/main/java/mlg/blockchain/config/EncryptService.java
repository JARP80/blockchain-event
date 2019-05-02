package mlg.blockchain.config;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class EncryptService {

    public static MessageDigest getMessageDigest() {
        MessageDigest digest;
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }

        return null;
    }
}
