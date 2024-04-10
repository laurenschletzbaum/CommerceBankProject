package com.example.commercebankproj.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String permissions;
    private String created_at;
    private String created_by;
    private String dateModified;
    private String modified_by;


    @OneToMany(mappedBy = "user_uid")
    private List<User_App> userapp = new ArrayList();


//    @OneToMany(mappedBy = "userInfo")
//    @JsonIgnore
//    private List<ApplicationInfo> applicationInfos = new ArrayList<>();
}
