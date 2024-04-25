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
    private Long id;


    @ManyToOne
    @JoinColumn(name = "appId")
    @JsonIgnore
    private ApplicationInfo applicationInfo;


    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private UserInfo userInfo;



    private String created_at;
    private String created_by;
    private String modified_at;
    private String modified_by;
}
