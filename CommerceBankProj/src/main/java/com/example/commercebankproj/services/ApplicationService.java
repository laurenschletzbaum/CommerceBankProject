package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.AssignAppUser;
import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.domain.UserApp;
import com.example.commercebankproj.repositories.ApplicationInfoRepository;
import com.example.commercebankproj.repositories.UserInfoRepository;
import com.example.commercebankproj.repositories.UserAppRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ApplicationService {
    private final UserInfoRepository userInfoRepository;
    private final ApplicationInfoRepository applicationInfoRepository;
    private final UserAppRepository userAppRepository;

    public ApplicationInfo creatApp(ApplicationInfo applicationInfo){

        applicationInfo.setCreated_at(new Timestamp(System.currentTimeMillis()).toString());
        applicationInfo.setCreated_by("Admin");


        return applicationInfoRepository.save(applicationInfo);
    }

    public String findByApplicationId(String applicationId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findByApplicationId(applicationId);
        return applicationInfo != null ? applicationInfo.getApplicationId() : null;
    }

    public String getApplicationIdByApplicationid(String applicationId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findByApplicationId(applicationId);
        return applicationInfo != null ? applicationInfo.getApplicationId() : null;
    }

    public String getApplicationId(Long appId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findById(appId).orElse(null);
        if (applicationInfo != null) {
            return applicationInfo.getApplicationId();
        } else {
            return null;
        }
    }




    public void assignUserToApp(Long userId, Long appId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findById(appId).orElseThrow();
        UserInfo userInfo = userInfoRepository.findById(userId).orElseThrow();

        UserApp userApp = new UserApp();
        userApp.setApplicationInfo(applicationInfo);
        userAppRepository.save(userApp);
    }

    /** Create **/
    public ApplicationInfo create(ApplicationInfo applicationInfo, String username) {
        UserInfo userInfo = userInfoRepository.findByUsername(username);
        //applicationInfo.setUserInfo(userInfo);

        System.out.println("Username: " + userInfo.getUsername());
        System.out.println("Password: " + userInfo.getPassword());
        System.out.println("Permissions: " + userInfo.getPermissions());
        return applicationInfoRepository.save(applicationInfo);
    }

    /** Read **/
    public List<ApplicationInfo> getAllApplicationInfo() { return applicationInfoRepository.findAll(); }
    public ApplicationInfo findById(Long appId) {
        return applicationInfoRepository.findById(appId).orElse(null);
    }

    public List<UserInfo> getAssignedUsers(Long appId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findById(appId).orElseThrow();
        return applicationInfo.getUserApps().stream()
                .map(UserApp::getUserInfo)
                .collect(Collectors.toList());
    }

    /** Update **/
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
    public void deleteApplicationById(Long appId) {
        applicationInfoRepository.deleteById(appId);
    }


}
