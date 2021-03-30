package com.facens.pooii.lab.ac1.ac1.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.facens.pooii.lab.ac1.ac1.entities.Event;

import org.springframework.stereotype.Component;

@Component
public class EventRepository {
    public List<Event> getEvents(){
        Event e1 = new Event();
        e1.setId(1l);
        e1.setName("Carnaval");
        e1.setDescription("Todo mundo pulando fantasiado!");
        e1.setPlace("Em todo lugar!");
        e1.setStartDate(LocalDate.of(2022, 02, 26));
        e1.setEndDate(LocalDate.of(2022, 03, 01));
        e1.setStartTime(LocalTime.of(00, 00));
        e1.setEndTime(LocalTime.of(23, 59));
        e1.setEmailContact("prefeitura@sp.gov.br");

        Event e2 = new Event();
        e2.setId(1l);
        e2.setName("Feira Tecnológica de São Paulo");
        e2.setDescription("Alguns dos melhores projetos feito por estudantes de São Paulo!");
        e2.setPlace("Expo Center Norte");
        e2.setStartDate(LocalDate.of(2022, 02, 20));
        e2.setEndDate(LocalDate.of(2022, 02, 20));
        e2.setStartTime(LocalTime.of(9, 00));
        e2.setEndTime(LocalTime.of(18, 00));
        e2.setEmailContact("prefeitura@sp.gov.br");

        List<Event> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);

        return list;
    }
}
