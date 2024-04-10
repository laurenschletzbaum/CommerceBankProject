package com.example.commercebankproj.services;

import com.example.commercebankproj.domain.ApplicationInfo;
import com.example.commercebankproj.domain.ServerInfo;
import com.example.commercebankproj.repositories.ApplicationInfoRepository;
import com.example.commercebankproj.repositories.ServerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServerService {
    private final ApplicationInfoRepository applicationInfoRepository;
    private final ServerRepository serverRepository;

    /** Create **/
    public ServerInfo create(ServerInfo serverInfo, String applicationId) {
        ApplicationInfo applicationInfo = applicationInfoRepository.findByApplicationId(applicationId);
        serverInfo.setApplicationInfo(applicationInfo);

        System.out.println("Source IP Address: " + serverInfo.getSourceAddress());
        System.out.println("Source Host: " + serverInfo.getSourceHost());
        System.out.println("Destination Address: " + serverInfo.getDestinationAddress());
        System.out.println("Destination Host: " + serverInfo.getDestinationHost());
        System.out.println("Port: " + serverInfo.getPort());
        System.out.println("Status: " + serverInfo.getStatus());
        System.out.println("Date Modified: " + serverInfo.getDateModified());
        System.out.println("Modified By:" + serverInfo.getModifiedBy());
        return serverRepository.save(serverInfo);
    }

    /** Read **/
    public ServerInfo findById(Long ipId) {
        return serverRepository.findById(ipId).orElse(null);
    }

    public List<ServerInfo> getAllIPAddresses() { return serverRepository.findAll(); }

    /** Update **/
    public ServerInfo update(ServerInfo updatedServerInfo) {
        Long ipId = updatedServerInfo.getIpId();
        ServerInfo existingServerInfo = serverRepository.findById(ipId).orElse(null);

        if (existingServerInfo != null) {
            existingServerInfo.setSourceAddress(updatedServerInfo.getSourceAddress());
            existingServerInfo.setSourceHost(updatedServerInfo.getSourceHost());
            existingServerInfo.setDestinationAddress(updatedServerInfo.getDestinationAddress());
            existingServerInfo.setDestinationHost(updatedServerInfo.getDestinationHost());
            existingServerInfo.setPort(updatedServerInfo.getPort());
            existingServerInfo.setStatus(updatedServerInfo.getStatus());
            existingServerInfo.setDateModified(updatedServerInfo.getDateModified());
            existingServerInfo.setModifiedBy(updatedServerInfo.getModifiedBy());
            return serverRepository.save(existingServerInfo);
        }else {
            return null;
        }
    }


    public String delete(Long ipId) {
        serverRepository.deleteById(ipId);
        return "ok";
    }
}
