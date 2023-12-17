package com.almeida.springmongodb.services;

import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    public static final String ID = UUID.randomUUID().toString();
    public static final String NAME = "Hommer Simpsons";
    public static final String EMAIL = "hommer@gmail.com.br";
    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserService service;

    private UserEntity user;
    @BeforeEach
    void setUp() {
        startUser();
    }
    @Test
    void whenFindByIdThenReturnAnUserInstance() {
        when(repository.findById(anyString())).thenReturn(Optional.ofNullable(user));

        UserEntity response = service.findById(ID);

        assertNotNull(response);
        assertEquals(UserEntity.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }
    @Test
    void findAll() {
    }
    @Test
    void created() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser() {
        user = UserEntity.builder()
            .id(ID)
            .name(NAME)
            .email(EMAIL)
            .build();


    }
}