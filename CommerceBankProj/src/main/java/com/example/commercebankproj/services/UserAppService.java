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

    public List<UserApp> findByUserUid(UserInfo userUid) {
        return userAppRepository.findByUserUid(userUid);
    }

    public void assignApplicationToUser(Long id, Long appId) {
        Optional<UserInfo> optionalUserInfo = userInfoRepository.findById(id);
        Optional<ApplicationInfo> optionalApplicationInfo = applicationInfoRepository.findById(appId);

        if (optionalUserInfo.isPresent() && optionalApplicationInfo.isPresent()) {
            UserInfo userInfo = optionalUserInfo.get();
            ApplicationInfo applicationInfo = optionalApplicationInfo.get();
            UserApp userApp = new UserApp();
            userApp.setUserUid(userInfo);
            userApp.setApp_info_uid(applicationInfo);

            userAppRepository.save(userApp);
            userInfo.getUserApp().add(userApp);
            userInfoRepository.save(userInfo);
        } else {
            throw new EntityNotFoundException("User or application not found.");
        }

    }

    public List<ApplicationInfo> getAssignedApps(Long id) {
        UserInfo userInfo = userInfoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id));
        List<UserApp> userApps = userAppRepository.findByUserUid(userInfo);
        List<ApplicationInfo> assignedApps = userApps.stream()
                .map(UserApp::getApp_info_uid)
                .collect(Collectors.toList());

        return assignedApps;
    }
}
