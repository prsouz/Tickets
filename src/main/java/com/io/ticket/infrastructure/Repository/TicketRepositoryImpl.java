package com.io.ticket.infrastructure.Repository;

import com.google.zxing.WriterException;
import com.io.ticket.infrastructure.Repository.Entity.CrudTicketEntity;
import com.io.ticket.infrastructure.Repository.Entity.Factory.TicketEntityFactory;
import com.io.ticket.infrastructure.Repository.Entity.TicketEntity;
import com.io.ticket.models.TicketDataModel;
import com.io.ticket.models.TicketDataModelFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;


@Repository
@Log4j2
public class TicketRepositoryImpl implements TicketRepository{

    @Autowired
    TicketEntityFactory ticketEntityFactory;

    @Autowired
    CrudTicketEntity crudTicketEntity;

    @Autowired
    TicketDataModelFactory ticketDataModelFactory;

    @Override
    public TicketDataModel saveTicket(TicketDataModel ticketDataModel) throws WriterException {

        try {
            TicketEntity ticketEntity = ticketEntityFactory.createTicketEntityFromTicketDataModel(ticketDataModel);
            ticketEntity = crudTicketEntity.save(ticketEntity);

            return ticketDataModelFactory.createTicketDataModelFromTicketEntity(ticketEntity);

        } catch (Exception ex){
            log.error("Error in the process to persist the ticket in DataBase. MSG: " + ex.getMessage());
            throw new PersistenceException(ex);
        }
    }
}
