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
    private String sourceAddress;
    private String sourceHost;
    private String destinationAddress;
    private String destinationHost;
    private String status;
    private String port;
    private String dateModified;
    private String modifiedBy;

    @ManyToOne
    @JoinColumn(name = "appId")
    private ApplicationInfo applicationInfo;
}
