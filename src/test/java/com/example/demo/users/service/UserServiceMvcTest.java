package com.example.demo.users.service;

import com.example.demo.lottery.service.LotteryService;
import com.example.demo.users.domain.User;
import com.example.demo.users.entity.UserEntity;
import com.example.demo.users.gateway.PostGateway;
import com.example.demo.users.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@WebMvcTest
class UserServiceMvcTest {

    @MockBean
    UserRepository userRepo;

    @MockBean
    LotteryService lotteryService;

    @MockBean
    UserService userService;

    @MockBean
    PostGateway postGateway;

    @Test
    public void shouldReturnUser(){
        //Arrange

        UserEntity user = new UserEntity();
        user.setId(10);
        user.setName("User 10");

        //stub

        when(userRepo.findById(10)).thenReturn(Optional.of(user));

        UserService userService = new UserService(userRepo);

        //Act
        User userResult = userService.getUsersById(10);

        //Assert
        assertEquals(user.getName(), userResult.getName());

    }
}