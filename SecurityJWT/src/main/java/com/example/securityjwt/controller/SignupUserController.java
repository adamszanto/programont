package com.example.securityjwt.controller;

import com.example.securityjwt.service.AuthService;
import com.example.securityjwt.service.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignupUserController {
    @Autowired
    private AuthService authService;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User createdUser = authService.createUser(user);
        if(createdUser == null) {
            return new ResponseEntity<>("User is not created, try again later", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }

    }
}
