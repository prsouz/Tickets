package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.models.TicketDataModel;

import java.security.NoSuchAlgorithmException;

public abstract class TicketGenerator {

    public abstract TicketDataModel createTicket(TicketDataModel ticketDataModel) throws NoSuchAlgorithmException, WriterException;
    }
