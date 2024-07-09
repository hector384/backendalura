package com.project.alura.repository;

import com.project.alura.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    UserDetails findByLogin(String username);
}
