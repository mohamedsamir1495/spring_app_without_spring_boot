package com.mohamedsamir1495.spring_app_without_spring_boot.controller;

import com.mohamedsamir1495.spring_app_without_spring_boot.dto.RegisterUserDTO;
import com.mohamedsamir1495.spring_app_without_spring_boot.service.UserService;
import com.mohamedsamir1495.spring_app_without_spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public User registerUser(@RequestBody RegisterUserDTO registerUserDTO) {
        return userService.registerUser(registerUserDTO);
    }
}
