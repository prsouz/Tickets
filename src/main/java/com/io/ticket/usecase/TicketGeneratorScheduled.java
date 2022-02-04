package com.io.ticket.usecase;

import com.io.ticket.models.TicketDataModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class TicketGeneratorScheduled extends TicketGenerator{

    @Override
    public TicketDataModel createTicket(TicketDataModel receivedTicketDataModel) {

        //To be implemented

        return null;
    }
}
