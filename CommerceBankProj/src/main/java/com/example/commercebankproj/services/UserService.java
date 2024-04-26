package com.example.commercebankproj.services;

import com.example.commercebankproj.DTO.ApplicationDTO;
import com.example.commercebankproj.DTO.UserDTO;
import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.UserApp;
import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.repositories.ApplicationInfoRepository;
import com.example.commercebankproj.repositories.UserAppRepository;
import com.example.commercebankproj.repositories.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserInfoRepository userInfoRepository;
    private final ApplicationInfoRepository applicationInfoRepository;
    private final UserAppRepository userAppRepository;

    public UserInfo create(UserInfo user) {
        user.setCreated_at(new Timestamp(System.currentTimeMillis()).toString());
        user.setCreated_by("Admin");
        return userInfoRepository.save(user);

    }

    public void assignAppToUser(Long appId, Long userId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findById(appId).orElseThrow();
        UserInfo userInfo = userInfoRepository.findById(userId).orElseThrow();

        UserApp userApp = new UserApp();
        userApp.setApplicationInfo(applicationInfo);
        userAppRepository.save(userApp);
    }

    public List<ApplicationInfo> getAssignedApps(Long userId) {
        UserInfo userInfo = userInfoRepository.findById(userId).orElseThrow();
        return userInfo.getUserApps().stream()
                .map(UserApp::getApplicationInfo)
                .collect(Collectors.toList());
    }

    @Transactional
    public String delete(Long id){
        userInfoRepository.deleteById(id);
        return "ok";
    }
    //Read

    public UserDTO findById(Long id) {
        UserInfo userInfo = userInfoRepository.findById(id).orElse(null);
        if (userInfo != null) {
            return mapUserInfoToDTO(userInfo);
        } else {
            return null;
        }
    }

    private UserDTO mapUserInfoToDTO(UserInfo userInfo) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userInfo.getId());
        userDTO.setUsername(userInfo.getUsername());
        // Map other fields
        return userDTO;
    }

    public UserDTO getUserById(Long id) {
        UserInfo userInfo = userInfoRepository.findById(id).orElse(null);
        if (userInfo != null) {
            return mapUserInfoToDTO(userInfo);
        }
        return null;
    }
    //Update

    public List<UserInfo> getAllUsers() { return userInfoRepository.findAll(); }

    public void updateAssignedApplications(Long id, List<Long> appIds) {
        UserInfo userInfo = userInfoRepository.findById(id).orElseThrow();
        List<ApplicationInfo> applicationInfos = applicationInfoRepository.findAllById(appIds);
        userInfo.setAssignedApplications(applicationInfos);
        userInfoRepository.save(userInfo);
    }

    public UserInfo update(UserInfo updatedUserInfo) {
        Long id = updatedUserInfo.getId();
        UserInfo existingUserInfo = userInfoRepository.findById(id).orElse(null);
        if (existingUserInfo != null) {
            existingUserInfo.setUsername(updatedUserInfo.getUsername());
            existingUserInfo.setPassword(updatedUserInfo.getPassword());
            existingUserInfo.setPermissions(updatedUserInfo.getPermissions());
            existingUserInfo.setDateModified(updatedUserInfo.getDateModified());
            return userInfoRepository.save(existingUserInfo);
        }else {
            return null;
        }
    }
}
