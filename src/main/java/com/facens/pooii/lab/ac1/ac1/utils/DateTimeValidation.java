package com.facens.pooii.lab.ac1.ac1.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DateTimeValidation {
    public static void valide(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime) {
        if(startDate.isAfter(endDate)){
            throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, "End date must be before the end date"
            );
        } else if(startDate.isEqual(endDate)) {
            if(startTime.isAfter(endTime) || startTime.equals(endTime)) {
                throw new ResponseStatusException(
                HttpStatus.UNAUTHORIZED, "End time must be before the end time"
            );
            }
        }
    }
}
