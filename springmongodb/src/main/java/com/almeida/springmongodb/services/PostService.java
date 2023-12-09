package com.almeida.springmongodb.services;

import com.almeida.springmongodb.domain.Post;
import com.almeida.springmongodb.repositories.PostRepository;
import com.almeida.springmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;
    public Post findById(String id) {
        return repository.findById(id)
            .orElseThrow(
                () -> new ObjectNotFoundException("Object not found"));
    }

}
