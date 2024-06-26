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
public class ApplicationInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appId;
    private String applicationId;
    private String description;
    private String created_at;
    private String created_by;
    private String dateModified;
    private String modifiedBy;

    public ApplicationInfo(Long appId) {
        this.appId = appId;
    }

    @OneToMany(mappedBy = "applicationInfo")
    private List<UserApp> userApps = new ArrayList();



    @OneToMany(mappedBy = "applicationInfo")
    private List<ServerInfo> serverInfos = new ArrayList<>();
}
