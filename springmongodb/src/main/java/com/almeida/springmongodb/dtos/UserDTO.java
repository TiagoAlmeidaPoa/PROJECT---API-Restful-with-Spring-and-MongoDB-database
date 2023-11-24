package com.almeida.springmongodb.dtos;

import com.almeida.springmongodb.domain.UserEntity;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String name;
    private String email;

}
