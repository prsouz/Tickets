package com.io.ticket.ports.in;

import com.google.zxing.WriterException;
import com.io.ticket.ports.in.transferObject.BalanceUpdateRequest;
import com.io.ticket.ports.in.transferObject.BalanceUpdateResponse;
import com.io.ticket.ports.in.transferObject.CreateTicketRequest;
import com.io.ticket.ports.in.transferObject.CreatedTicketResponse;
import org.springframework.http.ResponseEntity;

import java.security.NoSuchAlgorithmException;

public interface ETicketRestController {

    ResponseEntity<CreatedTicketResponse> createTicket(CreateTicketRequest createTicketRequest) throws NoSuchAlgorithmException, WriterException;
    ResponseEntity<CreatedTicketResponse> getTicket(String TokenId);
    ResponseEntity<BalanceUpdateResponse> balanceUpdate(BalanceUpdateRequest balanceUpdateRequest);


}
