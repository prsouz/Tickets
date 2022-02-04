package com.io.ticket.ports.in.transferObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.io.ticket.models.TicketTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedTicketResponse {

    private String accountID;
    private String tokenID;
    private TicketTypeEnum ticketType;
    private BigDecimal availableBalance;
    private Boolean tokenStatus;
    private LocalDate tokenExpireDate;
}
