package com.almeida.springmongodb.resources;

import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.dtos.UserDTO;
import com.almeida.springmongodb.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserEntity> list = service.findAll();
        List<UserDTO> dtos = list.stream().map(x -> mapper.map(x, UserDTO.class)).toList();
        return ResponseEntity.ok().body(dtos);
    }

}
