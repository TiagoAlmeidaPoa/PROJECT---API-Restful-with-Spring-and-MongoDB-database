package com.almeida.springmongodb.services;

import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.repositories.UserRepository;
import com.almeida.springmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    public UserEntity findById(String id) {
        return repository.findById(id)
            .orElseThrow(
                () -> new ObjectNotFoundException("Object not found"));
    }

}
