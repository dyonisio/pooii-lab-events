package com.facens.pooii.lab.ac1.ac1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.pooii.lab.ac1.ac1.dtos.PlaceDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.PlaceInsertDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.PlaceUpdateDTO;
import com.facens.pooii.lab.ac1.ac1.entities.Place;
import com.facens.pooii.lab.ac1.ac1.repositories.PlaceRepository;
import com.facens.pooii.lab.ac1.ac1.utils.FilterPlaceRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository repo;

    public Page<PlaceDTO> getPlaces(PageRequest pageRequest, FilterPlaceRequest filterRequest){
        Page<Place> list = repo.find(pageRequest, filterRequest.getName(), filterRequest.getAddress());
        return list.map( p -> new PlaceDTO(p));
    }

    public PlaceDTO getPlaceById(Long id){
        Optional<Place> op = repo.findById(id);
        Place place = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found"));

        return new PlaceDTO(place);
    }

    public PlaceDTO insert(PlaceInsertDTO dto){        
        Place entity = new Place(dto);
        entity = repo.save(entity);
        return new PlaceDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
        }
    }

    public PlaceDTO update(Long id, PlaceUpdateDTO dto){
        try{
            Place entity = repo.getOne(id);

            entity.setName(dto.getName());
            entity.setAddress(dto.getAddress());
            entity = repo.save(entity);
    
            return new PlaceDTO(entity);
        } catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Place not found");
        }
    }

    public List<PlaceDTO> toDTOList(List<Place> list){
        List<PlaceDTO> listDTO = new ArrayList<>();

        for(Place p : list){
            PlaceDTO dto = new PlaceDTO(
                p.getId(),
                p.getName(),
                p.getAddress(),
                p.getEvents()
            );
            listDTO.add(dto);
        }

        return listDTO;
    }
}
