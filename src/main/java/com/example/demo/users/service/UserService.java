package com.example.demo.users.service;

import com.example.demo.UserStore;
import com.example.demo.users.domain.User;
import com.example.demo.users.entity.UserEntity;
import com.example.demo.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo =userRepo;
    }

    public List<User> getUsers() {
        List<UserEntity> userEntities = userRepo.findAll();
        List users = new ArrayList<User>();
        userEntities.forEach(e->{
            User u = new User();
            u.setId(e.getId());
            u.setName(e.getName());
            users.add(u);
        });
        return users;
    }


    public User getUsersById(int id) {

        Optional<UserEntity> userEntityOptional = userRepo.findById(id);
        if(userEntityOptional.isPresent()){
            UserEntity userEntity = userEntityOptional.get();
            User user = new User();
            user.setId(userEntity.getId());
            user.setName(userEntity.getName());
            return user;
        }

        //TODO Handle exception
        return new User();
    }

    public void updateUserById(int id, User user){
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        entity.setId(id);
        userRepo.save(entity);
    }

    public void createUser(User user) {
        UserEntity entity = new UserEntity();
        entity.setName(user.getName());
        userRepo.save(entity);
    }

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }
}
