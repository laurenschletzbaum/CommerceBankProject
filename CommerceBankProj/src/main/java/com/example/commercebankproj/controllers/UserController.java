package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.ServerInfo;
import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.services.ApplicationService;
import com.example.commercebankproj.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final ApplicationService applicationService;

    @CrossOrigin
    @PostMapping("/users")
    public ResponseEntity<?> save(@RequestBody UserInfo userInfo) {

        return new ResponseEntity<>(userService.create(userInfo), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PostMapping("/assignAppToUser")
    public ResponseEntity<?> assignAppToUser(@RequestParam Long appId, @RequestParam Long userId) {
        userService.assignAppToUser(appId, userId);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @GetMapping("/assignedUsers/{appId}")
    public ResponseEntity<?> getAssignedUsers(@PathVariable Long appId) {
        List<UserInfo> userInfoList = applicationService.getAssignedUsers(appId);
        return new ResponseEntity<>(userInfoList, HttpStatus.OK);
    }

    //Read
    @CrossOrigin
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        List<UserInfo> userInfoList = userService.getAllUsers();
        return new ResponseEntity<>(userInfoList, HttpStatus.OK);
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
