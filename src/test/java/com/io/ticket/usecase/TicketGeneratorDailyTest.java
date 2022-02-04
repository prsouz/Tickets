package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.models.TicketDataModel;
import com.io.ticket.util.TicketDataModelGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.image.BufferedImage;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TicketGeneratorDailyTest {

    @InjectMocks
    TicketGeneratorDaily ticketGeneratorDaily;

    @Mock
    TokenGenerator tokenGenerator;

    @Mock
    QrCodeImageGenerator qrCodeImageGenerator;

    @InjectMocks
    TicketDataModelGenerator ticketDataModelGenerator;

    @Test
    void createDailyTicket() throws NoSuchAlgorithmException, WriterException {

        TicketDataModel baseTicket = ticketDataModelGenerator.getTicketDataModel();
        BufferedImage img = new BufferedImage(400, 600, BufferedImage.TYPE_3BYTE_BGR);

        Mockito.when(tokenGenerator.getUniqueTokens()).thenReturn("Token_ID");
        Mockito.when(qrCodeImageGenerator.getQrCode(Mockito.anyString())).thenReturn(img);

        TicketDataModel received = ticketGeneratorDaily.createTicket(baseTicket);

        assertEquals(baseTicket.getAccountID(), received.getAccountID());
        assertEquals("Token_ID", received.getTokenID());
        assertEquals(LocalDate.now(), received.getTokenExpireDate());
        assertEquals(img, received.getQrCodeImage());
    }


}