package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.UserApp;
import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.repositories.ApplicationInfoRepository;
import com.example.commercebankproj.repositories.UserAppRepository;
import com.example.commercebankproj.repositories.UserInfoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserAppService {
    private UserAppRepository userAppRepository;
    private UserInfoRepository userInfoRepository;
    private ApplicationInfoRepository applicationInfoRepository;

//    public List<UserApp> findByUserUid(UserInfo userUid) {
//        return userAppRepository.findByUserUid(userUid);
//    }

}
