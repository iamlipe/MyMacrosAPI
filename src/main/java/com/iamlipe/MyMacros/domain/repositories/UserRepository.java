package com.iamlipe.MyMacros.domain.repositories;

import com.iamlipe.MyMacros.domain.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    public UserDetails findByEmail(String email);

    public boolean existsByEmail(String email);
}
