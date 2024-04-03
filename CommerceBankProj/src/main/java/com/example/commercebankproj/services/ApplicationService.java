package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.repositories.ApplicationInfoRepository;
import com.example.commercebankproj.repositories.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ApplicationService {
    private final UserInfoRepository userInfoRepository;
    private final ApplicationInfoRepository applicationInfoRepository;

    public ApplicationInfo create(ApplicationInfo applicationInfo, String username) {
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        applicationInfo.setUserInfo(userInfo);

        System.out.println("Username: " + userInfo.getUsername());
        System.out.println("Password: " + userInfo.getPassword());
        System.out.println("Permissions: " + userInfo.getPermissions());
        return applicationInfoRepository.save(applicationInfo);
    }


    public ApplicationInfo findById(Long appId) {
        return applicationInfoRepository.findById(appId).orElse(null);
    }

    public ApplicationInfo update(ApplicationInfo updatedApplicationInfo) {
        Long appId = updatedApplicationInfo.getAppId();
        ApplicationInfo existingApplicationInfo = applicationInfoRepository.findById(appId).orElse(null);

        if (existingApplicationInfo != null) {
            existingApplicationInfo.setApplicationId(updatedApplicationInfo.getApplicationId());
            existingApplicationInfo.setDescription(updatedApplicationInfo.getDescription());

            return applicationInfoRepository.save(existingApplicationInfo);
        } else{
            return null;
        }
    }
     /** delete function **/
    @Transactional
    public String delete(Long id){
        userInfoRepository.deleteById(id);
        return "ok";
    }
}
