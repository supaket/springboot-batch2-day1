package com.example.demo.lottery.controller;

import com.example.demo.lottery.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LottoController {

    String memory;

    //DI = Dependency injection
    private final LotteryService lotteryService;

    public LottoController(LotteryService lotteryService){
        this.lotteryService = lotteryService;
    }

    @GetMapping("/lotto/{lotto}")
    public String lotto(@PathVariable("lotto") int lotto){
        return "Hi " + this.memory +" lotto is " + lotteryService.getNextLotto();
    }

    @PostMapping("/lotto")
    public void lotto(@RequestBody String name) {
        this.memory = name;
        System.out.println("name= "  + name);
    }

    @DeleteMapping("/lotto")
    public void lotto() {
        this.memory = "";
    }
}

//POSTMAN => REST CLIENT
