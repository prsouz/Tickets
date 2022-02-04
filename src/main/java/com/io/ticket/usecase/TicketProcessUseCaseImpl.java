package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.infrastructure.Repository.TicketRepository;
import com.io.ticket.models.TicketDataModel;
import com.io.ticket.ports.out.SenderSqsLambdaPort;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.PersistenceException;
import java.security.NoSuchAlgorithmException;

@Service
@Log4j2
public class TicketProcessUseCaseImpl implements TicketProcessUseCase{

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    SenderSqsLambdaPort senderSqsLambdaPort;

    @Override
    public TicketDataModel processTicketGenerateRequest(TicketDataModel ticketDataModel) throws NoSuchAlgorithmException, WriterException {

        String sqsErrormsg = "Error to the msg to SQS. MSG: ";
        String persistenceErrormsg = "Error to process to persiste the ticket Request in DataBase. MSG: ";
        String genericErrormsg = "Error to process the ticket Request. MSG: ";

        switch (ticketDataModel.getTicketType()){
            case DAILY_TICKET:
                try{
                    TicketGenerator ticketGeneratorDaily = new TicketGeneratorDaily();
                    TicketDataModel createdTicket = ticketGeneratorDaily.createTicket(ticketDataModel);
                    createdTicket = ticketRepository.saveTicket(createdTicket);
                    senderSqsLambdaPort.sendTicketToSqsLambda(createdTicket);

                    return createdTicket;

                } catch (ResponseStatusException rse){
                    log.error(sqsErrormsg + rse.getMessage());
                    throw rse;

                } catch (PersistenceException ps){
                    log.error(persistenceErrormsg + ps.getMessage());
                    throw ps;

                } catch (Exception ex){
                    log.error(genericErrormsg + ex.getMessage());
                    throw ex;
                }

            case MONTHY_TICKET:
                try{
                    TicketGenerator ticketGeneratorMonthly = new TicketGeneratorMonthly();
                    TicketDataModel createdTicket = ticketGeneratorMonthly.createTicket(ticketDataModel);
                    createdTicket = ticketRepository.saveTicket(createdTicket);
                    senderSqsLambdaPort.sendTicketToSqsLambda(createdTicket);

                    return createdTicket;

                } catch (ResponseStatusException rse){
                    log.error(sqsErrormsg + rse.getMessage());
                    throw rse;

                } catch (PersistenceException ps){
                    log.error(persistenceErrormsg + ps.getMessage());
                    throw ps;

                } catch (Exception ex){
                    log.error(genericErrormsg + ex.getMessage());
                    throw ex;
                }

            case SCHEDULED_TICKET:
                try{
                    TicketGenerator ticketGeneratorScheduled = new TicketGeneratorScheduled();
                    TicketDataModel createdTicket = ticketGeneratorScheduled.createTicket(ticketDataModel);
                    createdTicket = ticketRepository.saveTicket(createdTicket);
                    senderSqsLambdaPort.sendTicketToSqsLambda(createdTicket);

                    return createdTicket;

                } catch (ResponseStatusException rse){
                    log.error(sqsErrormsg + rse.getMessage());
                    throw rse;

                } catch (PersistenceException ps){
                    log.error(persistenceErrormsg + ps.getMessage());
                    throw ps;

                } catch (Exception ex){
                    log.error(genericErrormsg + ex.getMessage());
                    throw ex;
                }

            default:
                return null;
        }

    }
}
