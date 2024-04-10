package com.example.commercebankproj.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User_App {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Added user_apps variables
    private int user_apps_uid;


    @ManyToOne
    @JoinColumn(name = "appId")
    private ApplicationInfo app_info_uid;


    @ManyToOne
    @JoinColumn(name = "id")
    private UserInfo user_uid;



    private String created_at;
    private String created_by;
    private String modified_at;
    private String modified_by;
}
