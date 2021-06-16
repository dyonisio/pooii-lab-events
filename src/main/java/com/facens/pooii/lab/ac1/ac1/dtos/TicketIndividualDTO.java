package com.facens.pooii.lab.ac1.ac1.dtos;
import java.util.ArrayList;
import java.util.List;

import com.facens.pooii.lab.ac1.ac1.entities.Ticket;
import com.facens.pooii.lab.ac1.ac1.utils.TicketType.ticketType;

public class TicketIndividualDTO {
    public String type;
    public List<AttendListDTO> attendees = new ArrayList<>();

    public TicketIndividualDTO(){

    }

    public TicketIndividualDTO(ticketType type, List<Ticket> tickets) {
        if(type == ticketType.FREE)
            this.type = "FREE";
        else if (type == ticketType.PAYED)
            this.type = "PAYED";

        for(Ticket ticket : tickets)
            if(ticket.getType() == type)
                attendees.add(new AttendListDTO(ticket.getAttend()));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<AttendListDTO> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<AttendListDTO> attendees) {
        this.attendees = attendees;
    }

    
}
