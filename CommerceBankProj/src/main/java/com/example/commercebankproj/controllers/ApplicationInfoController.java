package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.services.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApplicationInfoController {
    private final ApplicationService applicationService;

    @CrossOrigin
    @PostMapping("/applicationInfo")
    public ResponseEntity<?> save(@RequestBody ApplicationInfo applicationInfo) {
        String username = "admin";
        return new ResponseEntity<>(applicationService.create(applicationInfo, username), HttpStatus.CREATED);
    }
}
