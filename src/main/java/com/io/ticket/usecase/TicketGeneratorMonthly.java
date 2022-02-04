package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.models.TicketDataModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.YearMonth;

@Component
@Log4j2
public class TicketGeneratorMonthly extends TicketGenerator{

    TokenGenerator tokenGenerator = new TokenGeneratorImpl();

    QrCodeImageGenerator qrCodeImageGenerator = new QrCodeImageGeneratorImpl();

    @Override
    public TicketDataModel createTicket(TicketDataModel receivedTicketDataModel) throws NoSuchAlgorithmException, WriterException {

        TicketDataModel ticketDataModel = new TicketDataModel();
        ticketDataModel.setTokenID(tokenGenerator.getUniqueTokens());
        ticketDataModel.setQrCodeImage(qrCodeImageGenerator.getQrCode(ticketDataModel.getTokenID()));
        ticketDataModel.setAccountID(receivedTicketDataModel.getAccountID());
        ticketDataModel.setTokenExpireDate(getLastDayOfMonth());
        ticketDataModel.setTicketType(receivedTicketDataModel.getTicketType());
        ticketDataModel.setTokenStatus(true);
        log.info("TicketDataModel Created: " + ticketDataModel);

        return ticketDataModel;
    }

    private LocalDate getLastDayOfMonth(){
        return YearMonth.now().atEndOfMonth();

    }
}
