package com.msa.user.controller;

import com.msa.user.entity.User;
import com.msa.repositpry.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User findOne = this.userRepository.findOne(id);
        return findOne;
    }

    @GetMapping("/all")
    public List<User> findAll() {
        List<User> allUser = this.userRepository.findAll();
        return allUser;
    }
}

