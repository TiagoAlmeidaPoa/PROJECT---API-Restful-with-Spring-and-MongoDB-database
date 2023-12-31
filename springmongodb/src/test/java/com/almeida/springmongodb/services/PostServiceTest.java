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
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

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
        when(repository.findById(anyString())).thenReturn(Optional.ofNullable(post));

        Post response = service.findById(ID);

        assertNotNull(response);
        assertEquals(Post.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(BODY, response.getBody());
        assertEquals(AUTHOR_NAME, response.getAuthor().getName());
    }

    @Test
    void whenFindByTitleThanReturnAListPosts() {
        when(repository.searchTitle(anyString())).thenReturn(List.of(post));

        List<Post> response = service.findByTitle("title");

        assertNotNull(response);
        assertEquals(Post.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(BODY, response.get(0).getBody());
        assertEquals(AUTHOR_NAME, response.get(0).getAuthor().getName());
    }

    @Test
    void WhenfullSearchThenReturnAListPost() {
        when(repository.fullSearch(anyString(), any(), any())).thenReturn(List.of(post));

        List<Post> response = service.fullSearch("title", new Date(), new Date());

        assertNotNull(response);
        assertEquals(Post.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(BODY, response.get(0).getBody());
        assertEquals(AUTHOR_NAME, response.get(0).getAuthor().getName());
    }

    private void startPost(){
        post = Post.builder()
            .id(ID)
            .title("test title")
            .date(LocalDateTime.parse("2024-01-03T10:15:30"))
            .author(new AuthorDTO(ID, AUTHOR_NAME))
            .body(BODY)
            .comments(new ArrayList<>())
            .build();
    }
}