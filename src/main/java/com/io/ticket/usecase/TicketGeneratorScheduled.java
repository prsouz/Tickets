package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.models.TicketDataModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;

@Log4j2
@Component
public class TicketGeneratorScheduled extends TicketGenerator{

    @Override
    public TicketDataModel createTicket(TicketDataModel receivedTicketDataModel) throws NoSuchAlgorithmException, WriterException {
        return null;
    }
}
