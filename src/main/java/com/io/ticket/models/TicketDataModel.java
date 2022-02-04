package com.io.ticket.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class TicketDataModel {

    private String accountID;
    private String tokenID;
    private TicketTypeEnum ticketType;
    private BigDecimal availableBalance;
    private Boolean tokenStatus;
    private LocalDate tokenExpireDate;
    private BufferedImage qrCodeImage;

}
