package com.example.demo.users.repository;

import com.example.demo.users.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findById(Integer id);
    Optional<UserEntity> findByName(String name);
    List<UserEntity> findAll();
    UserEntity  save(UserEntity entity);
    void deleteById(Integer id);
}
