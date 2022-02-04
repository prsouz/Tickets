package com.io.ticket.models;

import com.google.zxing.WriterException;
import com.io.ticket.infrastructure.Repository.Entity.TicketEntity;
import com.io.ticket.usecase.QrCodeImageGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class TicketDataModelFactoryImpl implements TicketDataModelFactory{

    @Autowired
    QrCodeImageGenerator qrCodeImageGenerator;

    @Override
    public TicketDataModel createTicketDataModelFromTicketEntity(TicketEntity ticketEntity) throws WriterException {
        log.info("Ticket Entity received: " + ticketEntity);
        TicketDataModel createdTicketDataModel = new TicketDataModel();

        createdTicketDataModel.setAccountID(ticketEntity.getAccountID());
        createdTicketDataModel.setTokenID(ticketEntity.getTokenID());
        createdTicketDataModel.setTicketType(TicketTypeEnum.getEnum(ticketEntity.getTicketType()));
        createdTicketDataModel.setAvailableBalance(ticketEntity.getAvailableBalance());
        createdTicketDataModel.setTokenStatus(ticketEntity.getTokenStatus());
        createdTicketDataModel.setTokenExpireDate(ticketEntity.getTokenExpireDate());
        createdTicketDataModel.setQrCodeImage(qrCodeImageGenerator.getQrCode(createdTicketDataModel.getTokenID()));
        log.info("Ticket Data Model created: " + createdTicketDataModel);

        return createdTicketDataModel;
    }
}
