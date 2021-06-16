package com.facens.pooii.lab.ac1.ac1.controllers;

import java.net.URI;

import javax.validation.Valid;

import com.facens.pooii.lab.ac1.ac1.dtos.EventDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.EventInsertDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.EventTicketSellDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.EventUpdateDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.TicketDTO;
import com.facens.pooii.lab.ac1.ac1.services.EventService;
import com.facens.pooii.lab.ac1.ac1.utils.FilterEventRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "6") Integer linesPerPage,
        @RequestParam(value = "direction", defaultValue = "ASC") String direction,
        @RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
        @RequestParam(value = "name", defaultValue = "") String name,
        @RequestParam(value = "startDate", defaultValue = "1900-01-01") String startDate,
        @RequestParam(value = "description", defaultValue = "") String description,
        @RequestParam(value = "priceTicket", defaultValue = "99999999") String priceTicket
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        FilterEventRequest filterRequest = FilterEventRequest.of(name, startDate, description, priceTicket);

        Page<EventDTO> list = service.getEvents(pageRequest, filterRequest);
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id){
        EventDTO dto = service.getClientById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EventDTO> insert(@Valid @RequestBody EventInsertDTO insertDto){
        EventDTO dto = service.insert(insertDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}") 
    public ResponseEntity<EventDTO> update(@PathVariable Long id, @Valid @RequestBody EventUpdateDTO updateDto){
        EventDTO dto = service.update(id, updateDto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("{idEvent}/places/{idPlace}")
    public ResponseEntity<EventDTO> addLocalEvent(@PathVariable Long idEvent, @PathVariable Long idPlace){
        EventDTO dto = service.addLocalEvent(idEvent, idPlace);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("{idEvent}/places/{idPlace}")
    public ResponseEntity<EventDTO> removeLocalEvent(@PathVariable Long idEvent, @PathVariable Long idPlace){
        EventDTO dto = service.removeLocalEvent(idEvent, idPlace);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping("{id}/tickets")
    public ResponseEntity<EventDTO> sellTicket(@PathVariable Long id, @Valid @RequestBody EventTicketSellDTO insertDto){
        EventDTO dto = service.sellTicket(insertDto, id);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}/tickets")
    public ResponseEntity<EventDTO> devolutionTicket(@PathVariable Long id, @Valid @RequestBody EventTicketSellDTO insertDto){
        EventDTO dto = service.devolutionTicket(insertDto, id);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("{idEvent}/tickets")
    public ResponseEntity<TicketDTO> getTickets(@PathVariable Long idEvent){
        TicketDTO dto = service.getTickets(idEvent);
        return ResponseEntity.ok().body(dto);
    }

}
