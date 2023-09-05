package com.example.demo.users.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserEntity {
    @Id
    private Long id;

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
