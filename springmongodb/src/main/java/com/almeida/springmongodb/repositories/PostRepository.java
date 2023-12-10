package com.almeida.springmongodb.repositories;

import com.almeida.springmongodb.domain.Post;
import com.almeida.springmongodb.domain.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);

}
