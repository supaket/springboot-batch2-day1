package com.example.demo.users.service;

import com.example.demo.users.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List users = new ArrayList<String>();
    public List<String> getUsers() {
        return users;
    }

    public void createUser(User user) {
        users.add(user.getName());
    }

    public void deleteUser(String name) {
        users.remove(name);
    }
}
