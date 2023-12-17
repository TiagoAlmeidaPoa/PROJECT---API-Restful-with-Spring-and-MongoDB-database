package com.almeida.springmongodb.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@Builder
public class CommentDTO implements Serializable {

    private String text;
    private LocalDateTime date;
    private AuthorDTO authorDTO;

}
