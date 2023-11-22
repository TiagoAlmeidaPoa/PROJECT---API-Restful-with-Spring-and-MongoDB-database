package com.almeida.springmongodb.config;

import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        UserEntity john = new UserEntity(null, "John Carter", "johnCart@gmail.com");
        UserEntity nedi = new UserEntity(null, "Nedi Flanders", "nediFlan@gmail.com");
        UserEntity borns = new UserEntity(null, "Sr Borns", "borns@gmail.com");

        userRepository.saveAll(Arrays.asList(john, nedi, borns));
    }
}
