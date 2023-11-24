package com.almeida.springmongodb.dtos;

import com.almeida.springmongodb.domain.UserEntity;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

}
