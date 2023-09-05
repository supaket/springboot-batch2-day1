package com.example.demo.users.service;

import com.example.demo.UserStore;
import com.example.demo.users.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserStore userStore;

    public List<String> getUsers() {
        return userStore.getUsers();
    }

    public void createUser(User user) {
        userStore.getUsers().add(user.getName());
    }

    public void deleteUser(String name) {
        userStore.getUsers().remove(name);
    }
}
