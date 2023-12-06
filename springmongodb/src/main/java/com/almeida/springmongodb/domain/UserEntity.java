package com.almeida.springmongodb.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity implements Serializable {
    @Id
    private String id;
    private String name;
    private String email;

    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

}
