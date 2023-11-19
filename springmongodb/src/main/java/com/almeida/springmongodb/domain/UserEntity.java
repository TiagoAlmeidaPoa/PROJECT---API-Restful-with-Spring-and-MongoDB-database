package com.almeida.springmongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
@AllArgsConstructor
public class UserEntity implements Serializable {

    private String id;
    private String name;
    private String email;

}
