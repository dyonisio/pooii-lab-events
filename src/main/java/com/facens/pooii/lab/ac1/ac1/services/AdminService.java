package com.facens.pooii.lab.ac1.ac1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.facens.pooii.lab.ac1.ac1.dtos.AdminDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.AdminInsertDTO;
import com.facens.pooii.lab.ac1.ac1.dtos.AdminUpdateDTO;
import com.facens.pooii.lab.ac1.ac1.entities.Admin;
import com.facens.pooii.lab.ac1.ac1.repositories.AdminRepository;
import com.facens.pooii.lab.ac1.ac1.utils.FilterAdminRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repo;

    public Page<AdminDTO> getAdmins(PageRequest pageRequest, FilterAdminRequest filterRequest){
        Page<Admin> list = repo.find(pageRequest, filterRequest.getName(), filterRequest.getEmail(), filterRequest.getPhoneNumber());
        return list.map( a -> new AdminDTO(a));
    }

    public AdminDTO getAdminById(Long id){
        Optional<Admin> op = repo.findById(id);
        Admin admin = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found"));

        return new AdminDTO(admin);
    }

    public AdminDTO insert(AdminInsertDTO dto){   
        PageRequest pageRequest = PageRequest.of(0, 1, Direction.valueOf("ASC"), "id");
        Page<Admin> list = repo.find(pageRequest, "", dto.getEmail(), "");

        if(!list.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already in database");

        Admin entity = new Admin(dto);
        entity = repo.save(entity);
        return new AdminDTO(entity);
    }

    public void delete(Long id){
        try{
            repo.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }
    }

    public AdminDTO update(Long id, AdminUpdateDTO dto){
        try{
            Admin entity = repo.getOne(id);

            entity.setName(dto.getName());
            entity.setPhoneNumber(dto.getPhoneNumber());
            entity = repo.save(entity);
    
            return new AdminDTO(entity);
        } catch(EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Admin not found");
        }
    }

    public List<AdminDTO> toDTOList(List<Admin> list){
        List<AdminDTO> listDTO = new ArrayList<>();

        for(Admin a : list){
            AdminDTO dto = new AdminDTO(
                a.getId(),
                a.getName(),
                a.getEmail(),
                a.getPhoneNumber()
            );
            listDTO.add(dto);
        }

        return listDTO;
    }
}
