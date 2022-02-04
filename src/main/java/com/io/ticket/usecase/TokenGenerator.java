package com.io.ticket.usecase;

import java.security.NoSuchAlgorithmException;

public interface TokenGenerator {
    String getUniqueTokens() throws NoSuchAlgorithmException;
}
