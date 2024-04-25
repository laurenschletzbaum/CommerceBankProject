package com.example.commercebankproj.domain;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignAppUser {

    private Long id;
    private String username;
    private String applicationId;
    private Long appId;


}
