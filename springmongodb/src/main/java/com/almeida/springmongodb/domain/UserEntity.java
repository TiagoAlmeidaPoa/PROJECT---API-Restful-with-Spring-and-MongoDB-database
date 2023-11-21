package com.almeida.springmongodb.domain;

import java.io.Serializable;

public record UserEntity(String id, String name, String email) implements Serializable {

}
