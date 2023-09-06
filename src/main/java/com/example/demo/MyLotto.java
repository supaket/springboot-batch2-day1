package com.example.demo;

import java.util.Random;

public class MyLotto {
    private final Random random;

    public MyLotto(Random random){
        this.random = random;
    }
    public int randomLotto(){
        return random.nextInt(100);
    }
}
