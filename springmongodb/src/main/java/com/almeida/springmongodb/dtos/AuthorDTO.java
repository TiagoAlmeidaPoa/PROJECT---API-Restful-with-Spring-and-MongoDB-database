package com.almeida.springmongodb.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDTO implements Serializable {

    private String id;
    private String name;

}
