package com.example.demo;

public class FizzBuzz {
    public String say(int input) {

        if(input==0){
            throw new IllegalStateException("Zero is not allowed");
        }
        String s = "";

        if(input%3==0){
            s = "Fizz";
        }

        if(input%5==0){
            s += "Buzz";
        }
        if(s==""){
            return String.valueOf(input);
        }
        return s;
    }
}
