package com.almeida.springmongodb.repositories;

import com.almeida.springmongodb.domain.Post;
import com.almeida.springmongodb.domain.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
