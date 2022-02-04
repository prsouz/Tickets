package com.io.ticket.ports.in.transferObject.factory;

import com.io.ticket.models.TicketDataModel;
import com.io.ticket.ports.in.transferObject.CreatedTicketResponse;

public interface CreatedTicketResponseFactory {
    CreatedTicketResponse createTicketResponseFromTicketDataModel(TicketDataModel ticketDataModel);
}
