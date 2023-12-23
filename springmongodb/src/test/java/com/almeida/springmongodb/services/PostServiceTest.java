package com.almeida.springmongodb.services;

import com.almeida.springmongodb.domain.Post;
import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.dtos.AuthorDTO;
import com.almeida.springmongodb.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    public static final String ID = UUID.randomUUID().toString();
    public static final String BODY = "body";
    public static final String AUTHOR_NAME = "author name";
    @Mock
    private PostRepository repository;
    @InjectMocks
    private PostService service;

    private Post post;

    @BeforeEach
    void setUp() {
        startPost();
    }

    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(post));

        Post response = service.findById(ID);

        assertNotNull(response);
        assertEquals(Post.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(BODY, response.getBody());
        assertEquals(AUTHOR_NAME, response.getAuthor().getName());
    }

    @Test
    void findByTitle() {
    }

    @Test
    void fullSearch() {
    }

    private void startPost(){
        post = Post.builder()
            .id(ID)
            .title("test title")
            .author(new AuthorDTO(ID, AUTHOR_NAME))
            .body(BODY)
            .comments(new ArrayList<>())
            .build();
    }
}