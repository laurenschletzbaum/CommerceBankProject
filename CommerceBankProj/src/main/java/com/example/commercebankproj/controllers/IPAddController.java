package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.IPAddInfo;
import com.example.commercebankproj.services.IPAddService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /** Read Function **/
    @CrossOrigin
    @GetMapping("/ipAddresses/{ipId}")
    public ResponseEntity<?> getById(@PathVariable Long ipId) {
        IPAddInfo ipAddInfo = ipAddService.findById(ipId);

        if (ipAddInfo != null) {
            return new ResponseEntity<>(ipAddService.findById(ipId), HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @GetMapping("/ipAddresses")
    public ResponseEntity<?> getAllIPAddresses() {
        List<IPAddInfo> ipAddInfoList = ipAddService.getAllIPAddresses();
        return new ResponseEntity<>(ipAddInfoList, HttpStatus.OK);
    }

    /** Update Function **/
    @CrossOrigin
    @PutMapping("/ipAddresses/{ipId}")
    public ResponseEntity<?> update(@PathVariable Long ipId, @RequestBody IPAddInfo updatedIPAddInfo) {
        IPAddInfo ipAddInfo = ipAddService.update(updatedIPAddInfo);
        if (ipAddInfo != null) {
            return ResponseEntity.ok(ipAddInfo);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
