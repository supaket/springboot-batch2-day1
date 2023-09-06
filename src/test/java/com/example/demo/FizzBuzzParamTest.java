package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class FizzBuzzParamTest {
    FizzBuzz fizzBuzz;

//    @Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
//    @Retention(RetentionPolicy.RUNTIME)
//    public @interface ArraySource {
//        int[] array() default {};
//    }
      @BeforeEach
    private void setUp() {
        fizzBuzz = new FizzBuzz();
    }


    @ParameterizedTest
    @ValueSource(ints = {1,2,4,6,7,8,10})
    public void shouldSayInputIfNotDivideBy3Or5(int input){
        //AAA

        //Arrange
        //int input = 1; // get it from input parameters

        //Act
        String result = fizzBuzz.say(input);

        //Assert
        assertEquals( String.valueOf(input), result);

    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, Fizz",
            "5, Buzz",
            "7, 7",
            "9, Fizz",
            "15, FizzBuzz"
    })
    public void ShouldSayFizzBuzAsAnInputProvided(int pInput, String pExpected){
        String result = fizzBuzz.say(pInput);
        assertEquals(pExpected, result);
    }

    @ParameterizedTest
    @CsvFileSource(resources="/input.csv")
    public void ShouldSayFizzBuzWithCsvFilesInput(int pInput, String pExpected){
        String result = fizzBuzz.say(pInput);
        assertEquals(pExpected, result);
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
