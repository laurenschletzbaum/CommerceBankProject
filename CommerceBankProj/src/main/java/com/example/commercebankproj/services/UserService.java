package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.IPAddInfo;
import com.example.commercebankproj.domain.UserInfo;
import com.example.commercebankproj.repositories.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserInfoRepository userInfoRepository;

    public UserInfo create(UserInfo user) {
        return userInfoRepository.save(user);
    }

    @Transactional
    public String delete(Long id){
        userInfoRepository.deleteById(id);
        return "ok";
    }
    //Read

    public UserInfo findById(Long id){
        return userInfoRepository.findById(id).orElse(null);
    }
    //Update

    public UserInfo update(UserInfo updatedUserInfo) {
        Long id = updatedUserInfo.getId();
        UserInfo existingUserInfo = userInfoRepository.findById(id).orElse(null);
        if (existingUserInfo != null) {
            existingUserInfo.setUsername(updatedUserInfo.getUsername());
            existingUserInfo.setPassword(updatedUserInfo.getPassword());
            existingUserInfo.setPermissions(updatedUserInfo.getPermissions());
            existingUserInfo.setDateModified(updatedUserInfo.getDateModified());
            existingUserInfo.setModifiedBy(updatedUserInfo.getModifiedBy());
            return userInfoRepository.save(existingUserInfo);
        }else {
            return null;
        }
    }
}
