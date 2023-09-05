package com.example.demo;

import com.example.demo.users.domain.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class UserStore {
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
    }

    List users = new ArrayList<User>();
}
