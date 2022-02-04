package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import com.io.ticket.models.TicketDataModel;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

@Component
@Log4j2
public class TicketGeneratorMonthly extends TicketGenerator{

    @Override
    public TicketDataModel createTicket(TicketDataModel receivedTicketDataModel) throws NoSuchAlgorithmException, WriterException {

        Integer lastDayOfTheMonth = Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println(lastDayOfTheMonth);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
        Date lastDay = cal.getTime();
        System.out.println(lastDay);

        return null;
    }
}
