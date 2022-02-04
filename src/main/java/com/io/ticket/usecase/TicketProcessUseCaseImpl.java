package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.infrastructure.Repository.TicketRepository;
import com.io.ticket.models.TicketDataModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.security.NoSuchAlgorithmException;

@Service
@Log4j2
public class TicketProcessUseCaseImpl implements TicketProcessUseCase{

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public TicketDataModel processTicketGenerateRequest(TicketDataModel ticketDataModel) throws NoSuchAlgorithmException, WriterException {

        switch (ticketDataModel.getTicketType()){
            case DAILY_TICKET:
                try{
                    TicketGenerator ticketGeneratorDaily = new TicketGeneratorDaily();
                    TicketDataModel createdTicket = ticketGeneratorDaily.createTicket(ticketDataModel);
                    createdTicket = ticketRepository.saveTicket(createdTicket);

                    return createdTicket;

                } catch (PersistenceException ps){
                    log.error("Error to process to persiste the ticket Request in DataBase. MSG: " + ps.getMessage());
                    throw ps;

                } catch (Exception ex){
                    log.error("Error to process the ticket Request. MSG: " + ex.getMessage());
                    throw ex;
                }

            case MONTHY_TICKET:
                TicketGenerator ticketGeneratorMonthly = new TicketGeneratorMonthly();
                return ticketGeneratorMonthly.createTicket(ticketDataModel);

            case SCHEDULED_TICKET:
                TicketGenerator ticketGeneratorScheduled = new TicketGeneratorScheduled();
                return ticketGeneratorScheduled.createTicket(ticketDataModel);

            default:
                return null;
        }

    }
}
