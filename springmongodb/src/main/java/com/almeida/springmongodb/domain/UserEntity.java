package com.almeida.springmongodb.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection = "user")
public record UserEntity(String id, String name, String email) implements Serializable {

}
