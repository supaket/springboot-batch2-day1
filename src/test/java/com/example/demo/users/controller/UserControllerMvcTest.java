package com.example.demo.users.controller;

import com.example.demo.lottery.service.LotteryService;
import com.example.demo.users.gateway.PostGateway;
import com.example.demo.users.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

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
}
