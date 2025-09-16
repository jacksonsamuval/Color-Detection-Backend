package com.colorDetection.colorDetection.repo;

import com.colorDetection.colorDetection.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Optional<Users> findUserByEmail(String email);

    Optional<Users> findUserByUsername(String username);
    Users findUsersByUsername(String username);

    Optional<Users> findUserByPhoneNo(String phoneNo);
}
