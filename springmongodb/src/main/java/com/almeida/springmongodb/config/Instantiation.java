package com.almeida.springmongodb.config;

import com.almeida.springmongodb.domain.Post;
import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.dtos.AuthorDTO;
import com.almeida.springmongodb.dtos.CommentDTO;
import com.almeida.springmongodb.repositories.PostRepository;
import com.almeida.springmongodb.repositories.UserRepository;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    @SneakyThrows
    public void run(String... args) {

        userRepository.deleteAll();
        postRepository.deleteAll();

        UserEntity john = UserEntity.builder()
            .name("John Carter")
            .email("johnCart@gmail.com")
            .build();
        UserEntity nedi = UserEntity.builder()
            .name("Nedi Flanders")
            .email("nediFlan@gmail.com")
            .build();
        UserEntity borns = UserEntity.builder()
            .name("Sr Borns")
            .email("borns@gmail.com")
            .build();

        userRepository.saveAll(Arrays.asList(john, nedi, borns));

        Post post1 = Post.builder()
            .id(null)
            .date(LocalDateTime.parse("2024-01-03T10:15:30"))
            .title("Lets go Disney")
            .body("i am go to travel from Orlando")
            .author(mapper.map(nedi, AuthorDTO.class))
            .build();

        Post post2 = Post.builder()
            .id(null)
            .date(LocalDateTime.parse("2023-12-03T10:15:30"))
            .title("Lets go New York")
            .body("i am go to travel from NY")
            .author(mapper.map(nedi, AuthorDTO.class))
            .build();

        CommentDTO c1 = CommentDTO.builder()
            .text("Have a good travel my friend !")
            .date(LocalDateTime.parse("2024-01-03T10:30:30"))
            .authorDTO(mapper.map(borns, AuthorDTO.class))
            .build();

        CommentDTO c2 = CommentDTO.builder()
            .text("how awesome!")
            .date(LocalDateTime.parse("2024-01-03T10:30:30"))
            .authorDTO(mapper.map(john, AuthorDTO.class))
            .build();

        CommentDTO c3 = CommentDTO.builder()
            .text("call me when you arrive !")
            .date(LocalDateTime.parse("2024-01-03T10:35:30"))
            .authorDTO(mapper.map(borns, AuthorDTO.class))
            .build();

        post1.getComments().addAll(List.of(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(List.of(post1, post2));

        nedi.getPosts().addAll(List.of(post1, post2));
        userRepository.save(nedi);
    }
}
