package com.facens.pooii.lab.ac1.ac1.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EventTicketSellDTO {
    @NotNull(message = "Id do Attende é obrigatório")
    private Long idAttend;
    @NotNull(message = "Tipo do ticket é obrigatório")
    @NotBlank(message = "Tipo do ticket não pode estar em branco")
    private String typeTicket;

    public EventTicketSellDTO(){

    }

    public EventTicketSellDTO(Long idAttend, String typeTicket) {
                this.idAttend = idAttend;
                this.typeTicket = typeTicket;
    }

    public Long getIdAttend() {
        return idAttend;
    }

    public void setIdAttend(Long idAttend) {
        this.idAttend = idAttend;
    }

    public String getTypeTicket() {
        return typeTicket;
    }

    public void setTypeTicket(String typeTicket) {
        this.typeTicket = typeTicket;
    }

    
}
