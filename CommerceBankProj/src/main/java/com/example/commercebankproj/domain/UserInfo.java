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


    @OneToMany(mappedBy = "userInfo")
    private List<UserApp> userApps = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo userInfo;

    @ManyToOne
    @JoinColumn(name = "app_id")
    private ApplicationInfo applicationInfo;

    @ManyToMany
    @JoinTable(
            name = "user_assigned_applications",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "application_id")
    )
    private List<ApplicationInfo> assignedApplications;
    public List<ApplicationInfo> getAssignedApplications() {
        return assignedApplications;
    }

    public void setAssignedApplications(List<ApplicationInfo> assignedApplications) {
        this.assignedApplications = assignedApplications;
    }

//    @OneToMany(mappedBy = "userInfo")
//    @JsonIgnore
//    private List<ApplicationInfo> applicationInfos = new ArrayList<>();
}
