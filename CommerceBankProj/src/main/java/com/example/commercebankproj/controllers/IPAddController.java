package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.IPAddInfo;
import com.example.commercebankproj.services.IPAddService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class IPAddController {
    private final IPAddService ipAddService;

    @CrossOrigin
    @PostMapping("/ipAddresses")
    public ResponseEntity<?> save(@RequestBody IPAddInfo ipAddInfo) {
        String applicationId = "MID";
        return new ResponseEntity<>(ipAddService.create(ipAddInfo, applicationId), HttpStatus.CREATED);
    }
}
