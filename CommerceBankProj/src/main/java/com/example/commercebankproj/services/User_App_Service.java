package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.domain.User_App;
import com.example.commercebankproj.repositories.User_App_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class User_App_Service {
    private final User_App_Repository user_app_repository;


}
