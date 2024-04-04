package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.IPAddInfo;
import com.example.commercebankproj.repositories.ApplicationInfoRepository;
import com.example.commercebankproj.repositories.IPAddInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class IPAddService {
    private final ApplicationInfoRepository applicationInfoRepository;
    private final IPAddInfoRepository ipAddInfoRepository;

    /** Create **/
    public IPAddInfo create(IPAddInfo ipAddInfo, String applicationId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findByApplicationId(applicationId);
        ipAddInfo.setApplicationInfo(applicationInfo);

        System.out.println("Source IP Address: " + ipAddInfo.getSourceAddress());
        System.out.println("Source Host: " + ipAddInfo.getSourceHost());
        System.out.println("Destination Address: " + ipAddInfo.getDestinationAddress());
        System.out.println("Destination Host: " + ipAddInfo.getDestinationHost());
        System.out.println("Port: " + ipAddInfo.getPort());
        System.out.println("Status: " + ipAddInfo.getStatus());
        System.out.println("Date Modified: " + ipAddInfo.getDateModified());
        System.out.println("Modified By:" + ipAddInfo.getModifiedBy());
        return ipAddInfoRepository.save(ipAddInfo);
    }

    /** Read **/
    public IPAddInfo findById(Long ipId) {
        return ipAddInfoRepository.findById(ipId).orElse(null);
    }

    public List<IPAddInfo> getAllIPAddresses() { return ipAddInfoRepository.findAll(); }

    /** Update **/
    public IPAddInfo update(IPAddInfo updatedIpAddInfo) {
        Long ipId = updatedIpAddInfo.getIpId();
        IPAddInfo existingIPAddInfo = ipAddInfoRepository.findById(ipId).orElse(null);

        if (existingIPAddInfo != null) {
            existingIPAddInfo.setSourceAddress(updatedIpAddInfo.getSourceAddress());
            existingIPAddInfo.setSourceHost(updatedIpAddInfo.getSourceHost());
            existingIPAddInfo.setDestinationAddress(updatedIpAddInfo.getDestinationAddress());
            existingIPAddInfo.setDestinationHost(updatedIpAddInfo.getDestinationHost());
            existingIPAddInfo.setPort(updatedIpAddInfo.getPort());
            existingIPAddInfo.setStatus(updatedIpAddInfo.getStatus());
            existingIPAddInfo.setDateModified(updatedIpAddInfo.getDateModified());
            existingIPAddInfo.setModifiedBy(updatedIpAddInfo.getModifiedBy());
            return ipAddInfoRepository.save(existingIPAddInfo);
        }else {
            return null;
        }
    }


}
