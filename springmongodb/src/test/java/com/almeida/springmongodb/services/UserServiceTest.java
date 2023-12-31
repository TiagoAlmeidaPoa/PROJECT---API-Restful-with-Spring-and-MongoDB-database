package com.almeida.springmongodb.services;

import com.almeida.springmongodb.domain.UserEntity;
import com.almeida.springmongodb.repositories.UserRepository;
import com.almeida.springmongodb.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    public static final String ID = UUID.randomUUID().toString();
    public static final String NAME = "Hommer Simpsons";
    public static final String EMAIL = "hommer@gmail.com.br";
    public static final String OBJECT_NOT_FOUND = "Object not found";
    public static final int INDEX = 0;
    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;

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
    void whenFindByIdThenReturnObjectNotFoundException() {
        when(repository.findById(anyString())).thenThrow(new ObjectNotFoundException(OBJECT_NOT_FOUND));
        
        try {
            service.findById(ID);
        } catch(Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJECT_NOT_FOUND, ex.getMessage());
        }
    }
    @Test
    void whenFindAllThenReturnAnUserList() {
        when(repository.findAll()).thenReturn(List.of(user));

        List<UserEntity> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(UserEntity.class, response.get(INDEX).getClass());
        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NAME, response.get(INDEX).getName());
        assertEquals(EMAIL, response.get(INDEX).getEmail());
    }
    @Test
    void whenCreatedThenReturnSuccess() {
        when(repository.save(any())).thenReturn(user);

        UserEntity response = service.created(user);

        assertNotNull(response);
        assertEquals(UserEntity.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void whenUpdateThenReturnSuccess() {
        when(repository.save(any())).thenReturn(user);
        when(repository.findById(anyString())).thenReturn(Optional.ofNullable(user));

        UserEntity response = service.update(user);

        assertNotNull(response);
        assertEquals(UserEntity.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void deleteWithSuccess() {
        when(repository.findById(anyString())).thenReturn(Optional.ofNullable(user));
        doNothing().when(repository).deleteById(anyString());

        service.delete(ID);

        verify(repository, times(1)).deleteById(anyString());
    }

    @Test
    void deleteWithObjectNotFound() {
        when(repository.findById(anyString())).thenThrow(new ObjectNotFoundException(OBJECT_NOT_FOUND));

        try{
            service.delete(ID);
        }catch (Exception e) {
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals(OBJECT_NOT_FOUND, e.getMessage());
        }
    }

    private void startUser() {
        user = UserEntity.builder()
            .id(ID)
            .name(NAME)
            .email(EMAIL)
            .build();
    }
}