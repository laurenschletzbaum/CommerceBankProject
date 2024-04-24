package com.example.commercebankproj.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Added user_apps variables
    private int user_apps_uid;


    @ManyToOne
    @JoinColumn(name = "appId")
    @JsonIgnore
    private ApplicationInfo app_info_uid;


    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private UserInfo userUid;



    private String created_at;
    private String created_by;
    private String modified_at;
    private String modified_by;
}
