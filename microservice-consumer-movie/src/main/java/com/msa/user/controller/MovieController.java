package com.msa.user.controller;

import com.msa.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class MovieController {
    @Value("${user.userServiceUrl}")
    private String userServiceUrl;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject(this.userServiceUrl+ id, User.class);
    }

    @GetMapping("/user/all")
    public List<User> findAll() {
        User[] users = this.restTemplate.getForObject("http://localhost:8000/all", User[].class);
        List<User> userList = Arrays.asList(users);
        return userList;
    }

}
