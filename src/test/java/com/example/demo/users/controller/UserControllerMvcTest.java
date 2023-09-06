package com.example.demo.users.controller;

import com.example.demo.lottery.service.LotteryService;
import com.example.demo.users.exception.UserNotFoundException;
import com.example.demo.users.gateway.PostGateway;
import com.example.demo.users.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest
public class UserControllerMvcTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    UserService userService;

    @MockBean
    LotteryService lotteryService;

    @MockBean
    PostGateway postGateway;

    @Test
    public void shouldAbleToCallUsersApi() throws Exception {

        when(userService.getUsers()).thenReturn(List.of());

        String result = this.mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
    }

    @Test
    public void shouldBeAbleToCallUserById() throws Exception {
        String result = this.mvc.perform(get("/users/10"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
    }

    @Test
    public void shouldBeNotAbleToCall() throws Exception {
        String result = this.mvc.perform(get("/newendpoint"))
                .andExpect(status().is4xxClientError())
                .andReturn()
                .getResponse().getContentAsString();
    }

    @Test
    public void shouldReturn404NotFoundWithErrorMessageGivenNotExistingUser() throws Exception {

        //Arrange -> make given 10 become not exist (user not found)
        when(userService.getUsersById(10)).thenThrow(new UserNotFoundException(10));

        //Act,Assert
        String result = this.mvc.perform(get("/users/10"))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse().getContentAsString();

        //assert
        //{"time":"2023-09-06T08:04:18.678+00:00","message":"User Id=10 Not found"}
        assertTrue(result.contains("User Id=10 Not found"));

    }
}
