package com.io.ticket.infrastructure.Repository.Entity;

import org.springframework.data.repository.CrudRepository;

public interface CrudTicketEntity extends CrudRepository<TicketEntity, Long> {
}
