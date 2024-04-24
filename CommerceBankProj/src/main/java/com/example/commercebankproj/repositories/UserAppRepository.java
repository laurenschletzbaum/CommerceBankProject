package com.example.commercebankproj.repositories;

import com.example.commercebankproj.domain.UserApp;
import com.example.commercebankproj.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {
    List<UserApp> findByUserUid(UserInfo userUid);
}
