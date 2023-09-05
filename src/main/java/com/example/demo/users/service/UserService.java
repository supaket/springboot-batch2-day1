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

    public List<User> getUsers() {
        return userStore.getUsers();
    }

    public User getUsersById(int id) {

        final User user = new User();

        userStore.getUsers().forEach(u-> {
            if(u.getId()==id) {
                user.setId(u.getId());
                user.setName(u.getName());
            }
        });

        return user;
    }

    public void updateUserById(int id, User user){
        userStore.getUsers().forEach(u-> {
            if(u.getId()==id) {
                u.setName(user.getName());
            }
        });
    }

    public void createUser(User user) {
        userStore.getUsers().add(user);
    }

    public void deleteUser(int id) {
        User user = new User();
        user.setId(id);
        userStore.getUsers().remove(user);
    }
}
