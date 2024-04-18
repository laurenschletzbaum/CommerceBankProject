package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @CrossOrigin
    @PostMapping("/users")
    public ResponseEntity<?> save(@RequestBody UserInfo userInfo) {

        return new ResponseEntity<>(userService.create(userInfo), HttpStatus.CREATED);
    }

    //Read
    @CrossOrigin
    @GetMapping("/users/{id}")
    public ResponseEntity<UserInfo> read(@PathVariable Long id) {
        UserInfo userInfo = userService.findById(id);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    //Update
    @CrossOrigin
    @PutMapping("/users/{id}")
    public ResponseEntity<UserInfo> update(@PathVariable Long id, @RequestBody UserInfo UpdatedUserInfo) {
        UserInfo updatedUserInfo = userService.update(UpdatedUserInfo);
        if (updatedUserInfo != null) {
            return ResponseEntity.ok(updatedUserInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @CrossOrigin
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
