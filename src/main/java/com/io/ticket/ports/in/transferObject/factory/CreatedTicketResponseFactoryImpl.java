package com.io.ticket.ports.in.transferObject.factory;

import com.io.ticket.models.TicketDataModel;
import com.io.ticket.ports.in.transferObject.CreatedTicketResponse;
import com.io.ticket.ports.in.transferObject.factory.CreatedTicketResponseFactory;
import org.springframework.stereotype.Component;

@Component
public class CreatedTicketResponseFactoryImpl implements CreatedTicketResponseFactory {

    @Override
    public CreatedTicketResponse createTicketResponseFromTicketDataModel(TicketDataModel ticketDataModel) {


        CreatedTicketResponse createdTicketResponse = new CreatedTicketResponse();
        createdTicketResponse.setAccountID(ticketDataModel.getAccountID());
        createdTicketResponse.setTokenID(ticketDataModel.getTokenID());
        createdTicketResponse.setTicketType(ticketDataModel.getTicketType());
        createdTicketResponse.setAvailableBalance(ticketDataModel.getAvailableBalance());
        createdTicketResponse.setTokenStatus(ticketDataModel.getTokenStatus());
        createdTicketResponse.setTokenExpireDate(ticketDataModel.getTokenExpireDate());

        return createdTicketResponse;
    }
}
