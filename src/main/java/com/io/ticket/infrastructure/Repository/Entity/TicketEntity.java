package com.io.ticket.infrastructure.Repository.Entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Tickets")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private Long id;

    @Column(name = "account_id", length = 100, nullable = false)
    private String accountID;

    @Column(name = "token_id", length = 100, nullable = false)
    private String tokenID;

    @Column(name = "ticket_type")
    private Integer ticketType;

    @Column(name = "balance")
    private BigDecimal availableBalance;

    @Column(name = "token_status")
    private Boolean tokenStatus;

    @Column(name = "token_expire_date")
    private LocalDate tokenExpireDate;

}
