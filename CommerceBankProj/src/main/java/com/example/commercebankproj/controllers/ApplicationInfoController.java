package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.AssignAppUser;
import com.example.commercebankproj.services.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
public class ApplicationInfoController {
    private final ApplicationService applicationService;

    /** Save Function **/
    @CrossOrigin
    @PostMapping("/applicationInfo")
    public ResponseEntity<?> save(@RequestBody ApplicationInfo applicationInfo) {
        String username = "admin";
        return new ResponseEntity<>(applicationService.creatApp(applicationInfo), HttpStatus.CREATED);
    }
    /** Read Functions **/


    @CrossOrigin
    @PostMapping("/userapp")
    public ResponseEntity<?> assignAppToUser(@RequestBody AssignAppUser assignAppUser) {
        String username = "admin";
        return new ResponseEntity<>(applicationService.assignAppToUser(assignAppUser), HttpStatus.CREATED);
    }
    /** Read Functions **/




    @CrossOrigin
    @GetMapping("/applicationInfo")
    public ResponseEntity<?> getAllApplicationInfo() {
        String username = "admin";
        return new ResponseEntity<>(applicationService.getAllApplicationInfo(), HttpStatus.OK);
    }

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
    /** Delete Function **/
    @CrossOrigin
    @DeleteMapping("/applicationInfo/{appId}")
    public ResponseEntity<?> deleteApplication(@PathVariable Long appId) {
        try {
            applicationService.deleteApplicationById(appId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Application Deletion Failed");
        }
    }
}
