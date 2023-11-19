package com.almeida.springmongodb.resources;

import com.almeida.springmongodb.domain.UserEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll(){
        UserEntity john = new UserEntity("1", "John Carter", "john@gmail.com");
        UserEntity alex = new UserEntity("2", "Alex Russo", "alexrusso@gmail.com");
        UserEntity felix = new UserEntity("3", "felix Lottus", "lottusfelix@gmail.com");
        List<UserEntity> users = new ArrayList<>(Arrays.asList(john, alex, felix));
        return ResponseEntity.ok().body(users);
    }

}
