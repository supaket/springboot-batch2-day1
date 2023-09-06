package com.example.demo.users.repository;

import com.example.demo.users.domain.User;
import com.example.demo.users.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldBeAbleToFindUserByName(){
        //Arrange
            //clean data
        userRepository.deleteAll();
            //save user
        UserEntity user = new UserEntity();
        user.setName("fake user");
        userRepository.save(user);

        //Act
            //call findByName
        Optional<UserEntity> userResult = userRepository.findByName("fake user");

        //Assert
            //Check the result is equal with saved user
        assertEquals(user.getName(), userResult.get().getName());
    }

    @Test
    public void shouldBeAbleToFindById(){
        //15:50

        //Arrange
        //clean data
        userRepository.deleteAll();
        //save user

        //save user
        UserEntity user = new UserEntity();
        user.setName("fake user");
        userRepository.save(user);


        //Act
        //call findByName
        Optional<UserEntity> userResult = userRepository.findById(1);

        //Assert
        //Check the result is equal with saved user
        assertEquals(user.getName(), userResult.get().getName());
    }
}