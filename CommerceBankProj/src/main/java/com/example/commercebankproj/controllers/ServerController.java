package com.example.commercebankproj.controllers;

import com.example.commercebankproj.domain.ServerInfo;
import com.example.commercebankproj.services.ServerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ServerController {
    private final ServerService serverService;

    @CrossOrigin
    @PostMapping("/ipAddresses")
    public ResponseEntity<?> save(@RequestBody ServerInfo serverInfo) {
        String applicationId = "MID";
        return new ResponseEntity<>(serverService.create(serverInfo, applicationId), HttpStatus.CREATED);
    }

    /** Read Function **/
    @CrossOrigin
    @GetMapping("/ipAddresses/{ipId}")
    public ResponseEntity<?> getById(@PathVariable Long ipId) {
        ServerInfo serverInfo = serverService.findById(ipId);

        if (serverInfo != null) {
            return new ResponseEntity<>(serverService.findById(ipId), HttpStatus.OK);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin
    @GetMapping("/ipAddresses")
    public ResponseEntity<?> getAllIPAddresses() {
        List<ServerInfo> serverInfoList = serverService.getAllIPAddresses();
        return new ResponseEntity<>(serverInfoList, HttpStatus.OK);
    }

    /** Update Function **/
    @CrossOrigin
    @PutMapping("/ipAddresses/{ipId}")
    public ResponseEntity<?> update(@PathVariable Long ipId, @RequestBody ServerInfo updatedServerInfo) {
        ServerInfo serverInfo = serverService.update(updatedServerInfo);
        if (serverInfo != null) {
            return ResponseEntity.ok(serverInfo);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    /** Delete Function **/
    @CrossOrigin
    @DeleteMapping("/ipAddresses/{ipId}")
    public ResponseEntity<?> deleteById(@PathVariable Long ipId) {
        return new ResponseEntity<>(serverService.delete(ipId), HttpStatus.OK);

    }
}
