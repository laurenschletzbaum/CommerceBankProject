package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.IPAddInfo;
import com.example.commercebankproj.repositories.ApplicationInfoRepository;
import com.example.commercebankproj.repositories.IPAddInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IPAddService {
    private final ApplicationInfoRepository applicationInfoRepository;
    private final IPAddInfoRepository ipAddInfoRepository;

    /** Create **/
    public IPAddInfo create(IPAddInfo ipAddInfo, String applicationId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findByApplicationId(applicationId);
        ipAddInfo.setApplicationInfo(applicationInfo);

        System.out.println("IP Address: " + ipAddInfo.getIpAddress());
        System.out.println("Status: " + ipAddInfo.getStatus());
        return ipAddInfoRepository.save(ipAddInfo);
    }

    /** Read **/
    public IPAddInfo findById(Long ipId) {
        return ipAddInfoRepository.findById(ipId).orElse(null);
    }

    /** Update **/
    public IPAddInfo update(IPAddInfo updatedIpAddInfo) {
        Long ipId = updatedIpAddInfo.getIpId();
        IPAddInfo existingIPAddInfo = ipAddInfoRepository.findById(ipId).orElse(null);

        if (existingIPAddInfo != null) {
            existingIPAddInfo.setStatus(updatedIpAddInfo.getStatus());
            existingIPAddInfo.setIpAddress(updatedIpAddInfo.getIpAddress());
            return ipAddInfoRepository.save(existingIPAddInfo);
        }else {
            return null;
        }
    }


}
