package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.services.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApplicationInfoController {
    private final ApplicationService applicationService;

    /** Save Function **/
    @CrossOrigin
    @PostMapping("/applicationInfo")
    public ResponseEntity<?> save(@RequestBody ApplicationInfo applicationInfo) {
        String username = "admin";
        return new ResponseEntity<>(applicationService.create(applicationInfo, username), HttpStatus.CREATED);
    }
    /** Read Function **/
    @CrossOrigin
    @GetMapping("/applicationInfo/{appId}")
    public ResponseEntity<?> getById(@PathVariable Long appId) {
        ApplicationInfo applicationInfo = applicationService.findById(appId);

        if (applicationInfo != null) {
            return ResponseEntity.ok(applicationInfo);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    /** Update Function **/
    @CrossOrigin
    @PutMapping("/applicationInfo/{appId}")
    public ResponseEntity<?> update(@PathVariable Long appId, @RequestBody ApplicationInfo updatedApplicationInfo) {
        ApplicationInfo applicationInfo = applicationService.update(updatedApplicationInfo);

        if (applicationInfo != null) {
            return ResponseEntity.ok(applicationInfo);
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}
