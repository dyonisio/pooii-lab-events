package com.facens.pooii.lab.ac1.ac1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.pooii.lab.ac1.ac1.dtos.AttendDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.AttendInsertDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.AttendUpdateDTO;
import com.facens.pooii.lab.ac1.ac1.entities.Attend;
import com.facens.pooii.lab.ac1.ac1.repositories.AttendRepository;
import com.facens.pooii.lab.ac1.ac1.utils.FilterAttendRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AttendService {

    @Autowired
    private AttendRepository repo;

    public Page<AttendDTO> getAttends(PageRequest pageRequest, FilterAttendRequest filterRequest){
        Page<Attend> list = repo.find(pageRequest, filterRequest.getName(), filterRequest.getEmail(), filterRequest.getBalance());
        return list.map( a -> new AttendDTO(a));
    }

    public AttendDTO getAttendById(Long id){
        Optional<Attend> op = repo.findById(id);
        Attend attend = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found"));

        return new AttendDTO(attend);
    }

    public AttendDTO insert(AttendInsertDTO dto){      
        Attend entity = new Attend(dto);
        entity = repo.save(entity);
        return new AttendDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
        }
    }

    public AttendDTO update(Long id, AttendUpdateDTO dto){
        try{
            Attend entity = repo.getOne(id);

            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity = repo.save(entity);
    
            return new AttendDTO(entity);
        } catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Attend not found");
        }
    }

    public List<AttendDTO> toDTOList(List<Attend> list){
        List<AttendDTO> listDTO = new ArrayList<>();

        for(Attend a : list){
            AttendDTO dto = new AttendDTO(
                a.getId(),
                a.getName(),
                a.getEmail(),
                a.getBalance()
            );
            listDTO.add(dto);
        }

        return listDTO;
    }
}
