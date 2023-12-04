package com.almeida.springmongodb.config;

import com.almeida.springmongodb.domain.Post;
import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.repositories.PostRepository;
import com.almeida.springmongodb.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    @Override
    @SneakyThrows
    public void run(String... args) {

        userRepository.deleteAll();
        postRepository.deleteAll();

        UserEntity john = new UserEntity(null, "John Carter", "johnCart@gmail.com");
        UserEntity nedi = new UserEntity(null, "Nedi Flanders", "nediFlan@gmail.com");
        UserEntity borns = new UserEntity(null, "Sr Borns", "borns@gmail.com");

        Post post1 = new Post(null, LocalDateTime.parse("2024-01-03T10:15:30"),"Lets go Disney", "i am go to travel from Orlando",nedi);
        Post post2 = new Post(null, LocalDateTime.parse("2023-12-03T10:15:30"),"Lets go New York", "i am go to travel from NY",nedi);

        userRepository.saveAll(Arrays.asList(john, nedi, borns));
        postRepository.saveAll(List.of(post1, post2));
    }
}
