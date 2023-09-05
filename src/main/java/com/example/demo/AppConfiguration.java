package com.example.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfiguration {

    @Bean
    //@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public UserStore getUsers(){
        return new UserStore();
    }
}
