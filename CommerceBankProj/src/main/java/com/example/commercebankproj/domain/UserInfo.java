package com.example.commercebankproj.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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


    @OneToMany(mappedBy = "userUid")
    private List<UserApp> userApp = new ArrayList<>();


//    @OneToMany(mappedBy = "userInfo")
//    @JsonIgnore
//    private List<ApplicationInfo> applicationInfos = new ArrayList<>();
}
