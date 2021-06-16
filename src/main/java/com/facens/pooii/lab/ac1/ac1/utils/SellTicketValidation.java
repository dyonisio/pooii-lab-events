package com.facens.pooii.lab.ac1.ac1.utils;

import com.facens.pooii.lab.ac1.ac1.utils.TicketType.ticketType;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SellTicketValidation {
    public static ticketType valide(String typeTicket) {
        if(typeTicket.toUpperCase().equals("PAYED")){
            return ticketType.PAYED;
        } else if (typeTicket.toUpperCase().equals("FREE")) {
            return ticketType.FREE;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "Ticket type must be 'PAYED' or 'FREE'!"
            );
        }
    }
}
