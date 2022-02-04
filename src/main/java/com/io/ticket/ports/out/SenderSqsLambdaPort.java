package com.io.ticket.ports.out;

import com.io.ticket.models.TicketDataModel;

public interface SenderSqsLambdaPort {
    TicketDataModel sendTicketToSqsLambda(TicketDataModel ticketDataModel);
}
