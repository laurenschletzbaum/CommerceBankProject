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

@Service
@AllArgsConstructor
public class ApplicationService {
    private final UserInfoRepository userInfoRepository;
    private final ApplicationInfoRepository applicationInfoRepository;
    private final UserAppRepository user_app_repository;

    public ApplicationInfo creatApp(ApplicationInfo applicationInfo){

        applicationInfo.setCreated_at(new Timestamp(System.currentTimeMillis()).toString());
        applicationInfo.setCreated_by("Admin");


        return applicationInfoRepository.save(applicationInfo);
    }

    public Long findByApplicationId(String applicationId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findByApplicationId(applicationId);
        if (applicationInfo != null) {
            return applicationInfo.getAppId();
        } else {
            return null;
        }
    }

    public String getApplicationId(Long appId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findById(appId).orElse(null);
        if (applicationInfo != null) {
            return applicationInfo.getApplicationId();
        } else {
            return null;
        }
    }




    public UserApp assignAppToUser(AssignAppUser assignAppUser){


        ApplicationInfo app = applicationInfoRepository.findById(assignAppUser.getAppId()).orElse(new ApplicationInfo());
        UserInfo user = userInfoRepository.findById(assignAppUser.getId()).orElse(new UserInfo());


        UserApp userapp = new UserApp();
        userapp.setApp_info_uid(app);
        userapp.setUserUid(user);
        userapp.setCreated_at(new Timestamp(System.currentTimeMillis()).toString());
        userapp.setCreated_by("Admin");


        return user_app_repository.save(userapp);
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
