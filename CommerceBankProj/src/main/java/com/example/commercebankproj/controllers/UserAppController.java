package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.AssignAppUser;
import com.example.commercebankproj.domain.UserApp;
import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.repositories.ApplicationInfoRepository;
import com.example.commercebankproj.repositories.UserAppRepository;
import com.example.commercebankproj.repositories.UserInfoRepository;
import com.example.commercebankproj.services.ApplicationService;
import com.example.commercebankproj.services.UserAppService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserAppController {
    private UserInfoRepository userInfoRepository;
    private ApplicationInfoRepository applicationInfoRepository;
    private ApplicationService applicationService;
    private final UserAppService userAppService;

    @PostMapping("/userApp")
    public ResponseEntity<?> assignApplicationToUser(@RequestBody AssignAppUser request) {
        try {
            Long appId = applicationService.findByApplicationId(request.getApplicationId());
            if (appId == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Application Id");
            }
            userAppService.assignApplicationToUser(request.getId(), appId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to assign User");
        }
    }

    @GetMapping("/users/{id}/assignedApps")
    public ResponseEntity<List<ApplicationInfo>> getAssignedApps(@PathVariable Long id) {
        List<ApplicationInfo> assignedApps = userAppService.getAssignedApps(id);
        return ResponseEntity.ok(assignedApps);
    }
}

