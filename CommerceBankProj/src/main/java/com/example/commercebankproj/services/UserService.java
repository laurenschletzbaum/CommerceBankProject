package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.repositories.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserInfoRepository userInfoRepository;

    public UserInfo create(UserInfo user) {
        return userInfoRepository.save(user);
    }
}
