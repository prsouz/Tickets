package com.io.ticket.models;

import com.google.zxing.WriterException;
import com.io.ticket.infrastructure.Repository.Entity.TicketEntity;

public interface TicketDataModelFactory {
    TicketDataModel createTicketDataModelFromTicketEntity(TicketEntity ticketEntity) throws WriterException;

}
