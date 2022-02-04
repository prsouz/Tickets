package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.models.TicketDataModel;

import java.security.NoSuchAlgorithmException;

public interface TicketProcessUseCase {
    TicketDataModel processTicketGenerateRequest(TicketDataModel ticketDataModel) throws NoSuchAlgorithmException, WriterException;
}
