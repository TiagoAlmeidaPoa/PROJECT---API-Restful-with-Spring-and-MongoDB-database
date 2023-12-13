package com.almeida.springmongodb.services;

import com.almeida.springmongodb.domain.Post;
import com.almeida.springmongodb.repositories.PostRepository;
import com.almeida.springmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    private Integer dia = 24 * 60 * 60 * 1000;

    @Autowired
    private PostRepository repository;
    public Post findById(String id) {
        return repository.findById(id)
            .orElseThrow(
                () -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String title) {
        return repository.searchTitle(title);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + dia);
        return repository.fullSearch(text, minDate, maxDate);
    }

}
