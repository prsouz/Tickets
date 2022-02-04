package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.infrastructure.Repository.TicketRepository;
import com.io.ticket.models.TicketDataModel;
import com.io.ticket.models.TicketTypeEnum;
import com.io.ticket.ports.out.SenderSqsLambdaPort;
import com.io.ticket.util.TicketDataModelGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.PersistenceException;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TicketProcessUseCaseImplTest {

    @InjectMocks
    TicketProcessUseCaseImpl ticketProcessUseCase;

    @Mock
    TicketRepository ticketRepository;

    @Mock
    SenderSqsLambdaPort senderSqsLambdaPort;

    @InjectMocks
    TicketDataModelGenerator ticketDataModelGenerator;

    @Test
    void processTicketGenerateRequest_TokenType_1() throws WriterException, NoSuchAlgorithmException {

        TicketDataModel baseTicket = ticketDataModelGenerator.getTicketDataModel();
        Mockito.when(ticketRepository.saveTicket(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);
        Mockito.when(senderSqsLambdaPort.sendTicketToSqsLambda(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);

        TicketDataModel received = ticketProcessUseCase.processTicketGenerateRequest(baseTicket);

        assertEquals(baseTicket.getAccountID(), received.getAccountID());

    }

    @Test
    void processTicketGenerateRequest_TokenType_1_Exception_PE() throws WriterException {

        TicketDataModel baseTicket = ticketDataModelGenerator.getTicketDataModel();
        Mockito.when(ticketRepository.saveTicket(Mockito.any(TicketDataModel.class))).thenThrow(PersistenceException.class);
        //Mockito.when(senderSqsLambdaPort.sendTicketToSqsLambda(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);

        assertThrows(PersistenceException.class, ()-> ticketProcessUseCase.processTicketGenerateRequest(baseTicket));
    }

    @Test
    void processTicketGenerateRequest_TokenType_1_Exception_RSE() throws WriterException {

        TicketDataModel baseTicket = ticketDataModelGenerator.getTicketDataModel();
        Mockito.when(ticketRepository.saveTicket(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);
        Mockito.when(senderSqsLambdaPort.sendTicketToSqsLambda(Mockito.any(TicketDataModel.class))).thenThrow(ResponseStatusException.class);

        assertThrows(ResponseStatusException.class, ()-> ticketProcessUseCase.processTicketGenerateRequest(baseTicket));
    }

    @Test
    void processTicketGenerateRequest_TokenType_1_Exception_EX() throws WriterException {

        TicketDataModel baseTicket = ticketDataModelGenerator.getTicketDataModel();
        Mockito.when(ticketRepository.saveTicket(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);
        Mockito.when(senderSqsLambdaPort.sendTicketToSqsLambda(Mockito.any(TicketDataModel.class))).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, ()-> ticketProcessUseCase.processTicketGenerateRequest(baseTicket));
    }

    @Test
    void processTicketGenerateRequest_TokenType_2() throws WriterException, NoSuchAlgorithmException {

        TicketDataModel baseTicket = ticketDataModelGenerator.getTicketDataModel();
        baseTicket.setTicketType(TicketTypeEnum.MONTHY_TICKET);
        Mockito.when(ticketRepository.saveTicket(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);
        Mockito.when(senderSqsLambdaPort.sendTicketToSqsLambda(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);

        TicketDataModel received = ticketProcessUseCase.processTicketGenerateRequest(baseTicket);

        assertEquals(baseTicket.getAccountID(), received.getAccountID());

    }

    @Test
    void processTicketGenerateRequest_TokenType_2_Exception_PE() throws WriterException {

        TicketDataModel baseTicket = ticketDataModelGenerator.getTicketDataModel();
        baseTicket.setTicketType(TicketTypeEnum.MONTHY_TICKET);
        Mockito.when(ticketRepository.saveTicket(Mockito.any(TicketDataModel.class))).thenThrow(PersistenceException.class);
        //Mockito.when(senderSqsLambdaPort.sendTicketToSqsLambda(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);

        assertThrows(PersistenceException.class, ()-> ticketProcessUseCase.processTicketGenerateRequest(baseTicket));
    }

    @Test
    void processTicketGenerateRequest_TokenType_2_Exception_RSE() throws WriterException {

        TicketDataModel baseTicket = ticketDataModelGenerator.getTicketDataModel();
        baseTicket.setTicketType(TicketTypeEnum.MONTHY_TICKET);
        Mockito.when(ticketRepository.saveTicket(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);
        Mockito.when(senderSqsLambdaPort.sendTicketToSqsLambda(Mockito.any(TicketDataModel.class))).thenThrow(ResponseStatusException.class);

        assertThrows(ResponseStatusException.class, ()-> ticketProcessUseCase.processTicketGenerateRequest(baseTicket));
    }

    @Test
    void processTicketGenerateRequest_TokenType_2_Exception_EX() throws WriterException {

        TicketDataModel baseTicket = ticketDataModelGenerator.getTicketDataModel();
        baseTicket.setTicketType(TicketTypeEnum.MONTHY_TICKET);
        Mockito.when(ticketRepository.saveTicket(Mockito.any(TicketDataModel.class))).thenReturn(baseTicket);
        Mockito.when(senderSqsLambdaPort.sendTicketToSqsLambda(Mockito.any(TicketDataModel.class))).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, ()-> ticketProcessUseCase.processTicketGenerateRequest(baseTicket));
    }

}