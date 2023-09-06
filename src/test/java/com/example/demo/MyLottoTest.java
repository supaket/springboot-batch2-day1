package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MyLottoTest {


    @Mock
    Random random;

    @Test
    public void shouldCallRandomNextIntWithParam100(){

        //Arrange
        Random randomSpy = spy(new Random());

        //Act
        MyLotto myLotto = new MyLotto(randomSpy);
        myLotto.randomLotto();

        // Capture the argument using ArgumentCaptor
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(randomSpy).nextInt(argumentCaptor.capture());

        int capturedValue = argumentCaptor.getValue();

        assertEquals(capturedValue, 100);

    }

    @Test
    public void shouldReturnAnyNumberIfCall(){
        //Arrange
        when(random.nextInt(100)).thenReturn(55);

        //Act
        MyLotto myLotto = new MyLotto(random);
        int lotto = myLotto.randomLotto();

        //assert
        assertEquals(55, lotto);
    }
}