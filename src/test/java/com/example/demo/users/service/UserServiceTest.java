package com.example.demo.users.service;

import com.example.demo.users.domain.User;
import com.example.demo.users.entity.UserEntity;
import com.example.demo.users.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepo;

    @Test
    public void shouldReturnUser(){
        //Arrange

        UserEntity user = new UserEntity();
        user.setId(10);
        user.setName("User 10");

        //stub
        //UserRepository userRepo = Mockito.mock(UserRepository.class);

        when(userRepo.findById(10)).thenReturn(Optional.of(user));

        UserService userService = new UserService(userRepo);

        //Act
        User userResult = userService.getUsersById(10);

        //Assert
        assertEquals(user.getName(), userResult.getName());

    }
}