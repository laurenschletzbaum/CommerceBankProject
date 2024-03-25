package com.example.commercebankproj.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPAddInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ipId;
    private String ipAddress;
    private String status;

    @ManyToOne
    @JoinColumn(name = "appId")
    private ApplicationInfo applicationInfo;
}
