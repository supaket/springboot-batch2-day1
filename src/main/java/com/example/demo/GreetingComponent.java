package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class GreetingComponent {
    public void SayHi(){
        System.out.println("Greeting Spring boot");
    }
}
