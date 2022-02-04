package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.models.TicketDataModel;
import com.io.ticket.models.TicketTypeEnum;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.image.BufferedImage;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TicketGeneratorDailyTest {

    @InjectMocks
    TicketGeneratorDaily ticketGeneratorDaily;

    @Mock
    TokenGenerator tokenGenerator;

    @Mock
    QrCodeImageGenerator qrCodeImageGenerator;


    @Test
    void createDailyTicket() throws NoSuchAlgorithmException, WriterException {

        TicketDataModel baseTicket = new TicketDataModel();
        baseTicket.setAccountID("Test_Account_ID");
        baseTicket.setTicketType(TicketTypeEnum.DAILY_TICKET);
        BufferedImage img = new BufferedImage(400, 600, BufferedImage.TYPE_3BYTE_BGR);

        Mockito.when(tokenGenerator.getUniqueTokens()).thenReturn("TokenID");
        Mockito.when(qrCodeImageGenerator.getQrCode(Mockito.anyString())).thenReturn(img);

        TicketDataModel received = ticketGeneratorDaily.createTicket(baseTicket);

        assertEquals(baseTicket.getAccountID(), received.getAccountID());
    }


}