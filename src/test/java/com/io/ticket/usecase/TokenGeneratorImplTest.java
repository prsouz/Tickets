package com.io.ticket.usecase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TokenGeneratorImplTest {

   @InjectMocks
   private TokenGeneratorImpl tokenGenerator;

    @Test
    void getUniqueTokens() throws NoSuchAlgorithmException {

        String stringReturned = tokenGenerator.getUniqueTokens();
        Assertions.assertNotNull(stringReturned);
        assertEquals(String.class, stringReturned.getClass());

    }
}