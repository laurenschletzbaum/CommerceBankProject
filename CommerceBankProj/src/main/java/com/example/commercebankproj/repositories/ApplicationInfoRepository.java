package com.example.commercebankproj.repositories;

import com.example.commercebankproj.domain.ApplicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationInfoRepository extends JpaRepository<ApplicationInfo, Long> {
    ApplicationInfo findByApplicationId(String applicationId);
}
