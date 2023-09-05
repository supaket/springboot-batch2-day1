package com.example.demo.users.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super(String.valueOf("User Id=" + id + " Not found"));
    }
}
