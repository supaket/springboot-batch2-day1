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
    public List<String> getUser() {
        return userService.getUsers();
    }

    //Post -> new user
    @PostMapping("/users")
    public  List<String> postUser(@RequestBody User user){

        System.out.println(user.getName()); //{"name": "user name3"}
        System.out.println(user.getId());
        //userService.createUser(user);
        return userService.getUsers();
        //System.out.println(user.getName());
    }

    //Delete -> remove user with specific name
    @DeleteMapping("/users/{name}")
    public  List<String> deleteUser(@PathVariable String name){
        userService.deleteUser(name);
        return userService.getUsers();
    }
}
