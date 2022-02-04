package com.io.ticket.infrastructure.Repository.Entity.Factory;

import com.io.ticket.infrastructure.Repository.Entity.TicketEntity;
import com.io.ticket.models.TicketDataModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class TicketEntityFactoryImpl implements TicketEntityFactory{


    @Override
    public TicketEntity createTicketEntityFromTicketDataModel(TicketDataModel ticketDataModel) {

        log.info("TicketDataModel Received: " + ticketDataModel);
        TicketEntity createdTicketEntity = new TicketEntity();

        createdTicketEntity.setAccountID(ticketDataModel.getAccountID());
        createdTicketEntity.setTokenID(ticketDataModel.getTokenID());
        createdTicketEntity.setTicketType(ticketDataModel.getTicketType().getCode());
        createdTicketEntity.setTokenStatus(ticketDataModel.getTokenStatus());
        createdTicketEntity.setAvailableBalance(ticketDataModel.getAvailableBalance());
        createdTicketEntity.setTokenExpireDate(ticketDataModel.getTokenExpireDate());
        log.info("Ticket Entity created: " + createdTicketEntity);

        return createdTicketEntity;
    }
}
