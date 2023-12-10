package com.almeida.springmongodb.domain;

import com.almeida.springmongodb.dtos.AuthorDTO;
import com.almeida.springmongodb.dtos.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Document
public class Post implements Serializable {

    @Id
    private String id;
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime date;
    private String title;
    private String body;
    private AuthorDTO author;
    @Builder.Default
    private List<CommentDTO> comments = new ArrayList<>();

}
