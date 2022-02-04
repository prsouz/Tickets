package com.io.ticket.util;

import com.io.ticket.models.TicketDataModel;
import com.io.ticket.models.TicketTypeEnum;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class TicketDataModelGenerator {

    public TicketDataModel getTicketDataModel(){

        TicketDataModel ticketDataModel = new TicketDataModel();
        ticketDataModel.setAccountID("accountId");
        ticketDataModel.setTokenID("tokenId");
        ticketDataModel.setTicketType(TicketTypeEnum.DAILY_TICKET);
        ticketDataModel.setTokenExpireDate(LocalDate.now());
        ticketDataModel.setAvailableBalance(BigDecimal.TEN);
        ticketDataModel.setTokenStatus(true);

        return ticketDataModel;
    }


}
