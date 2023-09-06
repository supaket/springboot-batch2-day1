package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {
    FizzBuzz fizzBuzz;

    @BeforeEach
    private void setUp() {
        fizzBuzz = new FizzBuzz();
    }

    @Test
    public void shouldSayInputIfNotDivideBy3Or5(){
        //AAA

        //Arrange
        int input = 1;

        //Act
        String result = fizzBuzz.say(input);

        //Assert
        assertEquals( String.valueOf(input), result);

    }


    @Test
    public void shouldSayFizzIfInputCanDivideBy3(){

        //Arrange
        int input = 3;

        //Act
        String result = fizzBuzz.say(input);

        //Assert
        assertEquals("Fizz", result);
    }

    @Test
    public void shouldSayBuzzIfInputCanDivideBy5(){

        //Arrange
        int input  = 5;

        //Act
        String result = fizzBuzz.say(input);

        //Assert
        assertEquals("Buzz", result);

    }

    @Test
    public void shouldSayFizzBuzzIfBothInputCanDivideBy3And5(){
        //Arrange
        int input  = 15;

        //Act
        String result = fizzBuzz.say(input);

        //Assert
        assertEquals("FizzBuzz", result);

    }

    @Test
    public void shouldSayProperFizzBuzzWithRandomNumber(){
        //Arrange
        int input  = new Random().nextInt(15) + 1;


        //Act
        String result = fizzBuzz.say(input);

        String expect = input%3==0?"Fizz":input%5==0?"Buzz":String.valueOf(input);

        //Assert
        assertEquals(expect, result);
    }

    @Test
    public void shouldSayFizzBuzzWithRandomDivideBy3And5() {
        //Arrange
        List<Integer> inputs = Arrays.asList(15, 45, 90, 75);

        //Act
        inputs.forEach(i->{
            String result = fizzBuzz.say(i);
            //Assert
            assertEquals("FizzBuzz", result);
        });
    }

    @Test
    public void shouldThrowExceptionIfInputIs0(){
        int input = 0;

        IllegalStateException thrown = Assertions.assertThrows(IllegalStateException.class, () -> {
            //Code under test
            fizzBuzz.say(input);
        });

        assertEquals("Zero is not allowed",thrown.getMessage());
    }
}
