package com.io.ticket.usecase;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Log4j2
@Component
public class TokenGeneratorImpl implements TokenGenerator {

    @Override
    public String getUniqueTokens() throws NoSuchAlgorithmException {

        MessageDigest id = MessageDigest.getInstance("SHA-256");
        id.update(UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8));
        String uniqueToken = bytesToHex(id.digest());
        log.info("Created Token: " + uniqueToken);

        return uniqueToken;
    }

    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
