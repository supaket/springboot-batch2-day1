package com.example.demo.lottery.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class LotteryService {
    public  Integer getNextLotto() {
        return new Random().nextInt(10);
    }
}
