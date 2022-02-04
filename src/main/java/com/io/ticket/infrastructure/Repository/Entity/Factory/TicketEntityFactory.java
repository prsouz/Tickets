package com.io.ticket.infrastructure.Repository.Entity.Factory;

import com.io.ticket.infrastructure.Repository.Entity.TicketEntity;
import com.io.ticket.models.TicketDataModel;

public interface TicketEntityFactory {
    TicketEntity createTicketEntityFromTicketDataModel(TicketDataModel ticketDataModel);
}
