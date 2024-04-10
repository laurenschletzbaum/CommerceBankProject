package com.example.commercebankproj.repositories;

import com.example.commercebankproj.domain.ServerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepository extends JpaRepository<ServerInfo, Long> {

}