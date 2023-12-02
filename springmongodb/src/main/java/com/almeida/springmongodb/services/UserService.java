package com.almeida.springmongodb.services;

import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.dtos.UserDTO;
import com.almeida.springmongodb.repositories.UserRepository;
import com.almeida.springmongodb.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    public UserEntity findById(String id) {
        return repository.findById(id)
            .orElseThrow(
                () -> new ObjectNotFoundException("Object not found"));
    }

    public UserEntity created(UserEntity user) {
        return repository.save(user);
    }

    public UserEntity update(UserEntity user) {
        UserEntity newObj = repository.findById(user.getId()).orElseThrow(
            () -> new ObjectNotFoundException("Object not found"));
        mapper.map(user, newObj);
        return repository.save(user);
    }

    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

}
