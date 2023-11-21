package com.almeida.springmongodb.services;

import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

}
