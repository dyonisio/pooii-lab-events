package com.facens.pooii.lab.ac1.ac1.repositories;
import com.facens.pooii.lab.ac1.ac1.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository <Event, Long> {
    
}
