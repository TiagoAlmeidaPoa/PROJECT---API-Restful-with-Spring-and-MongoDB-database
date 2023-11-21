package com.almeida.springmongodb.resources;

import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll(){
        List<UserEntity> users = service.findAll();
        return ResponseEntity.ok().body(users);
    }

}
