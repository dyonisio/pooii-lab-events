package com.facens.pooii.lab.ac1.ac1.controllers;

import java.util.List;

import com.facens.pooii.lab.ac1.ac1.dtos.EventDTO;
import com.facens.pooii.lab.ac1.ac1.services.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvents(){
        List<EventDTO> list = service.getEvents();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id){
        EventDTO dto = service.getClientById(id);
        return ResponseEntity.ok(dto);
    }
}
