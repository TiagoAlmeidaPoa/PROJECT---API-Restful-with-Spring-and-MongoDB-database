package com.almeida.springmongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
@Document(collection = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserEntity implements Serializable {
    private String id;
    private String name;
    private String email;
}
