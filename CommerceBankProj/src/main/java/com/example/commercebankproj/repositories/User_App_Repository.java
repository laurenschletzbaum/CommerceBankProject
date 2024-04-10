package com.example.commercebankproj.repositories;

import com.example.commercebankproj.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_App_Repository extends JpaRepository<UserInfo, Long> {
}
