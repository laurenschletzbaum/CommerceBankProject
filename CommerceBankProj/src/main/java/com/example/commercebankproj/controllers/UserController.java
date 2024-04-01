package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @CrossOrigin
    @PostMapping("/users")
    public ResponseEntity<?> save(@RequestBody UserInfo userInfo) {

        return new ResponseEntity<>(userService.create(userInfo), HttpStatus.CREATED);
    }
    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
