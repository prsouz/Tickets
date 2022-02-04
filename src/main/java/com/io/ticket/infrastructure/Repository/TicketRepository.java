package com.io.ticket.infrastructure.Repository;

import com.google.zxing.WriterException;
import com.io.ticket.models.TicketDataModel;

public interface TicketRepository {
    TicketDataModel saveTicket(TicketDataModel ticketDataModel) throws WriterException;
}
