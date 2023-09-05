package com.example.demo.users.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class PostGateway {
    private final RestTemplate restTemplate;
    private final String postApiUrl;

    public PostGateway(@Value("${post.api.url}") String postApiUrl, RestTemplate restTemplate){
        this.restTemplate = restTemplate;
        this.postApiUrl = postApiUrl;
    }


    public Optional<PostResponse> getTodosById(int id) {
        String url = String.format("%s/%d", postApiUrl, id);
        System.out.println(url);
        return Optional.ofNullable(restTemplate.getForObject(url , PostResponse.class));
    }
}
