package com.example.demo.users.controller;

import com.example.demo.users.domain.User;
import com.example.demo.users.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUser() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUsersById(id);
    }

    //Post -> new user
    @PostMapping("/users")
    public  List<User> postUser(@RequestBody User user){

        System.out.println(user.getName()); //{"name": "user name3"}
        System.out.println(user.getId());
        userService.createUser(user);
        return userService.getUsers();
    }


    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") int id,
                           @RequestBody User user){
        userService.updateUserById(id, user);
        return userService.getUsersById(id);
    }

    //Delete -> remove user with specific id
    @DeleteMapping("/users/{id}")
    public  List<User> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return userService.getUsers();
    }
}
