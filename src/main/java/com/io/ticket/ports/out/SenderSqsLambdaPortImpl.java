package com.io.ticket.ports.out;

import com.io.ticket.models.TicketDataModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SenderSqsLambdaPortImpl implements SenderSqsLambdaPort{

    @Override
    public TicketDataModel sendTicketToSqsLambda(TicketDataModel ticketDataModel) {

        //to be implemented

        return null;
    }
}
