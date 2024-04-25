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
import com.example.commercebankproj.services.UserService;
import jakarta.persistence.EntityNotFoundException;
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
    private UserService userService;
    private UserAppRepository userAppRepository;
}


