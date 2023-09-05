package com.example.demo.users.controller;

import java.util.Date;

public class ErrorResponse {
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    Date time;
    String message;
}
