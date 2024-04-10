package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.AssignAppUser;
import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.domain.User_App;
import com.example.commercebankproj.repositories.ApplicationInfoRepository;
import com.example.commercebankproj.repositories.UserInfoRepository;
import com.example.commercebankproj.repositories.User_App_Repository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationService {
    private final UserInfoRepository userInfoRepository;
    private final ApplicationInfoRepository applicationInfoRepository;
    private final User_App_Repository user_app_repository;

    public ApplicationInfo creatApp(ApplicationInfo applicationInfo){

        return applicationInfoRepository.save(applicationInfo);
    }




    public User_App assignAppToUser(AssignAppUser assignAppUser){


        ApplicationInfo app = applicationInfoRepository.findById(assignAppUser.getAppId()).orElse(new ApplicationInfo());
        UserInfo user = userInfoRepository.findById(assignAppUser.getId()).orElse(new UserInfo());


        User_App userapp = new User_App();
        userapp.setApp_info_uid(app);
        userapp.setUser_uid(user);
        userapp.setCreated_at("04/10/2004");
        userapp.setCreated_by("admin");


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
    @Transactional
    public String delete(Long id){
        userInfoRepository.deleteById(id);
        return "ok";
    }


}
