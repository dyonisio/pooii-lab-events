package com.facens.pooii.lab.ac1.ac1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.pooii.lab.ac1.ac1.dtos.EventDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.EventInsertDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.EventUpdateDTO;
import com.facens.pooii.lab.ac1.ac1.entities.Admin;
import com.facens.pooii.lab.ac1.ac1.entities.Event;
import com.facens.pooii.lab.ac1.ac1.repositories.AdminRepository;
import com.facens.pooii.lab.ac1.ac1.repositories.EventRepository;
import com.facens.pooii.lab.ac1.ac1.utils.DateTimeValidation;
import com.facens.pooii.lab.ac1.ac1.utils.FilterEventRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EventService {

    @Autowired
    private EventRepository repo;
    @Autowired
    private AdminRepository repoAdmin;

    public Page<EventDTO> getEvents(PageRequest pageRequest, FilterEventRequest filterRequest){
        Page<Event> list = repo.find(pageRequest, filterRequest.getName(), filterRequest.getStartDate(), filterRequest.getDescription(), filterRequest.getPriceTicket());
        return list.map( e -> new EventDTO(e));
    }

    public EventDTO getClientById(Long id){
        Optional<Event> op = repo.findById(id);
        Event eve = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        return new EventDTO(eve);
    }

    public EventDTO insert(EventInsertDTO dto){
        DateTimeValidation.valide(dto.getStartDate(), dto.getEndDate(), dto.getStartTime(), dto.getEndTime());

        Event entity = new Event(dto);

        Optional<Admin> op = repoAdmin.findById(dto.getIdAdmin());        
        Admin admin = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin não existe"));
        
        entity.setAdmin(admin);
        entity = repo.save(entity);
        return new EventDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

    public EventDTO update(Long id, EventUpdateDTO dto){
        try{
            Event entity = repo.getOne(id);

            entity.setDescription(dto.getDescription());
            entity.setStartDate(dto.getStartDate());
            entity.setEndDate(dto.getEndDate());
            entity.setStartTime(dto.getStartTime());
            entity.setEndTime(dto.getEndTime());
            entity = repo.save(entity);
    
            return new EventDTO(entity);
        } catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

    public List<EventDTO> toDTOList(List<Event> list){
        List<EventDTO> listDTO = new ArrayList<>();

        for(Event e : list){
            EventDTO dto = new EventDTO(
                e.getId(),
                e.getName(),
                e.getDescription(),
                e.getStartDate(),
                e.getEndDate(),
                e.getStartTime(),
                e.getEndTime(),
                e.getEmailContact(),
                e.getAmountFreeTickets(),
                e.getAmountPayedTickets(),
                e.getPriceTicket()
            );
            listDTO.add(dto);
        }

        return listDTO;
    }
}
