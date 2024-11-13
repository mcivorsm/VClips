package com.backendvc.bevc;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findUserByEmail(String email);
    UserInfo findByUsername(String username);
}
