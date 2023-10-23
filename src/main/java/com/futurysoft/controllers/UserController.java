package com.futurysoft.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurysoft.models.User;
import com.futurysoft.repositories.UserRepository;

import static com.futurysoft.constant.Constant.API_V1;

@RestController
@RequestMapping(path = API_V1 + "user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
