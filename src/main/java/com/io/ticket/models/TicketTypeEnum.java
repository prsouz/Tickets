package com.io.ticket.models;

public enum TicketTypeEnum {
    DAILY_TICKET(1),
    MONTHY_TICKET(2),
    SCHEDULED_TICKET(3);

    private Integer code;

    TicketTypeEnum(Integer code){
        this.code = code;
    }

    public static TicketTypeEnum getEnum(Integer ticketCode){
        for(TicketTypeEnum e : TicketTypeEnum.values()){
            if(e.code.equals(ticketCode)){
                return e;
            }
        }
        return null;
    }

    public Integer getCode(){
        return code;
    }
}
