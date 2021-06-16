package com.facens.pooii.lab.ac1.ac1.utils;

import com.facens.pooii.lab.ac1.ac1.entities.Event;
import com.facens.pooii.lab.ac1.ac1.entities.Place;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PlaceEventValidation {
    public static void valide(Event event, Place place) {
        if(place.getEvents().isEmpty())
            return;

        for(Event ev : place.getEvents())
            if(ev.getId() == event.getId())
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, "This place already included in this event!"
            );  

        for(Event eve : place.getEvents()){
            boolean sameDay = event.getStartDate().isEqual(event.getEndDate()) && eve.getStartDate().isEqual(eve.getEndDate()) && event.getStartDate().isEqual(eve.getStartDate());

            if((event.getStartDate().equals(eve.getStartDate()) && event.getEndDate().equals(eve.getEndDate())) && !sameDay){
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Ops! Have an event in this date! #1"
                );  
            }
            if(((event.getStartDate().isAfter(eve.getStartDate()) && event.getStartDate().isBefore(eve.getEndDate())) ||
                event.getEndDate().isAfter(eve.getStartDate()) && event.getEndDate().isBefore(eve.getEndDate())) && !sameDay){
                    throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Ops! Have an event in this date! #2"
                );   
            }
            if(event.getStartDate().isEqual(eve.getEndDate()) && !sameDay){
                if(event.getStartTime().isBefore(eve.getEndTime()))
                    throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Ops! Have an event in this hour! #1"
                );   
            }
            if(event.getEndDate().isEqual(eve.getStartDate()) && !sameDay){
                if(event.getEndTime().isAfter(eve.getStartTime()))
                    throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Ops! Have an event in this hour! #2"
                );   
            }
            if(eve.getStartDate().isAfter(event.getStartDate()) && eve.getEndDate().isBefore(event.getEndDate())){
                throw new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED, "Ops! Have an event in this date! #3"
                );  
            }
            if(sameDay){
                if(((event.getStartTime().isAfter(eve.getStartTime()) || event.getStartTime().equals(eve.getStartTime())) && (event.getStartTime().isBefore(eve.getEndTime()) || event.getStartTime().equals(eve.getEndTime()))) || 
                   ((event.getEndTime().isAfter(eve.getStartTime()) || event.getEndTime().equals(eve.getStartTime())) && (event.getEndTime().isBefore(eve.getEndTime()) || event.getEndTime().equals(eve.getEndTime()))))
                        throw new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED, "Ops! Have an event in this hour! #3"
                        );  
            }
        }
    }
}
