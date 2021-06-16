package com.facens.pooii.lab.ac1.ac1.services;

import java.io.Console;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.pooii.lab.ac1.ac1.dtos.EventDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.EventInsertDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.EventTicketSellDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.EventUpdateDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.TicketDTO;
import com.facens.pooii.lab.ac1.ac1.entities.Admin;
import com.facens.pooii.lab.ac1.ac1.entities.Attend;
import com.facens.pooii.lab.ac1.ac1.entities.Event;
import com.facens.pooii.lab.ac1.ac1.entities.Place;
import com.facens.pooii.lab.ac1.ac1.entities.Ticket;
import com.facens.pooii.lab.ac1.ac1.repositories.AdminRepository;
import com.facens.pooii.lab.ac1.ac1.repositories.AttendRepository;
import com.facens.pooii.lab.ac1.ac1.repositories.EventRepository;
import com.facens.pooii.lab.ac1.ac1.repositories.PlaceRepository;
import com.facens.pooii.lab.ac1.ac1.repositories.TicketRepository;
import com.facens.pooii.lab.ac1.ac1.utils.DateTimeValidation;
import com.facens.pooii.lab.ac1.ac1.utils.FilterEventRequest;
import com.facens.pooii.lab.ac1.ac1.utils.PlaceEventValidation;
import com.facens.pooii.lab.ac1.ac1.utils.SellTicketValidation;
import com.facens.pooii.lab.ac1.ac1.utils.TicketType.ticketType;

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
    @Autowired
    private PlaceRepository repoPlace;
    @Autowired
    private AttendRepository repoAttend;
    @Autowired
    private TicketRepository repoTicket;

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
        Optional<Event> opEvent = repo.findById(id);
        Event event = opEvent.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        if(event.getPayedTicketsSelled() > 0 || event.getFreeTicketsSelled() > 0){
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "This event have tickets with Attendees!!!!"
            );
        }

        try{
            repo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

    public EventDTO update(Long id, EventUpdateDTO dto){
        DateTimeValidation.valide(dto.getStartDate(), dto.getEndDate(), dto.getStartTime(), dto.getEndTime());

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
                e.getPriceTicket(),
                e.getFreeTicketsSelled(),
                e.getPayedTicketsSelled(),
                e.getPlaces(), 
                e.getTickets()
            );
            listDTO.add(dto);
        }

        return listDTO;
    }

    public EventDTO addLocalEvent(Long idEvent, Long idPlace) {
        Optional<Event> opEvent = repo.findById(idEvent);
        Event event = opEvent.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        Optional<Place> opPlace = repoPlace.findById(idPlace);
        Place place = opPlace.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));

        PlaceEventValidation.valide(event, place);

        event.addPlace(place);
        repo.save(event);

        place.addEvent(event);
        repoPlace.save(place);       

        return new EventDTO(event);
    }

    public EventDTO removeLocalEvent(Long idEvent, Long idPlace) {
        Optional<Event> opEvent = repo.findById(idEvent);
        Event event = opEvent.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        Optional<Place> opPlace = repoPlace.findById(idPlace);
        Place place = opPlace.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));

        if(event.getPlaces().contains(place)){
            event.getPlaces().remove(place);
            place.getEvents().remove(event);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED, "The place isn't registered in the event!"
            );
        }

        repo.save(event);
        repoPlace.save(place);       

        return new EventDTO(event);
    }

    public EventDTO sellTicket(EventTicketSellDTO dto, Long idEvent){
        Optional<Attend> opAttend = repoAttend.findById(dto.getIdAttend());
        Attend attend = opAttend.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found"));

        Optional<Event> opEvent = repo.findById(idEvent);
        Event event = opEvent.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        ticketType ticketT = SellTicketValidation.valide(dto.getTypeTicket());

        switch(ticketT){
            case FREE:
                if(event.getAmountFreeTickets() > 0){
                    Ticket ticket = new Ticket(event, attend, ticketT, 0d, Instant.now());
                    for(Ticket atTicket : attend.getTickets())
                        if(atTicket.getEvent().getId() == ticket.getEvent().getId())
                            throw new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED, "This attend already have this ticket!"
                            );
                    repoTicket.save(ticket);

                    event.setAmountFreeTickets(event.getAmountFreeTickets()-1);
                    event.setFreeTicketsSelled(event.getFreeTicketsSelled()+1);
                    event.addTicket(ticket);
                    repo.save(event);

                    attend.addTicket(ticket);
                    repoAttend.save(attend);                    
                } else
                    throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Doest have available FREE tickets!"
                    );
                break;
            case PAYED:
                if(event.getAmountPayedTickets() > 0){
                    Ticket ticket = new Ticket(event, attend, ticketT, event.getPriceTicket(), Instant.now());
                    for(Ticket atTicket : attend.getTickets())
                        if(atTicket.getEvent().getId() == ticket.getEvent().getId())
                            throw new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED, "This attend already have this ticket!"
                            );

                    repoTicket.save(ticket);

                    event.setAmountPayedTickets(event.getAmountPayedTickets()-1);
                    event.setPayedTicketsSelled(event.getPayedTicketsSelled()+1);
                    event.addTicket(ticket);
                    repo.save(event);

                    attend.addTicket(ticket);
                    repoAttend.save(attend);  

                    event.setAmountPayedTickets(event.getAmountPayedTickets()-1);
                } else
                    throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Doest have available PAYED tickets!"
                    );
                break;
        }
        
        return new EventDTO(event);
    }

    public EventDTO devolutionTicket(EventTicketSellDTO dto, Long idEvent) {
        Optional<Attend> opAttend = repoAttend.findById(dto.getIdAttend());
        Attend attend = opAttend.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found"));

        Optional<Event> opEvent = repo.findById(idEvent);
        Event event = opEvent.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        ticketType ticketT = SellTicketValidation.valide(dto.getTypeTicket());

        for(Ticket atTicket : attend.getTickets())
            if(atTicket.getEvent().getId() == idEvent && atTicket.getType() == ticketT){
                switch(ticketT){
                    case FREE:
                        event.setAmountFreeTickets(event.getAmountFreeTickets()+1);
                        event.setFreeTicketsSelled(event.getFreeTicketsSelled()-1);
                        event.removeTicket(atTicket);
                        repo.save(event);

                        attend.removeTicket(atTicket);
                        repoAttend.save(attend);

                        repoTicket.delete(atTicket);
                        return new EventDTO(event);

                    case PAYED:
                        event.setAmountPayedTickets(event.getAmountPayedTickets()+1);
                        event.setPayedTicketsSelled(event.getPayedTicketsSelled()-1);
                        event.removeTicket(atTicket);
                        repo.save(event);

                        attend.setBalance(attend.getBalance()+event.getPriceTicket());
                        attend.removeTicket(atTicket);
                        repoAttend.save(attend);

                        repoTicket.delete(atTicket);
                        return new EventDTO(event);
                }
            }

        throw new ResponseStatusException(
            HttpStatus.UNAUTHORIZED, "The attend doesn't have ticket for this event!"
        );
    }

    public TicketDTO getTickets(Long idEvent) {
        Optional<Event> opEvent = repo.findById(idEvent);
        Event event = opEvent.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        return new TicketDTO(event);
    }
}
