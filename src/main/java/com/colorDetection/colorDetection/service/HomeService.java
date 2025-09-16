package com.colorDetection.colorDetection.service;

import com.colorDetection.colorDetection.dto.LoginDto;
import com.colorDetection.colorDetection.jwt.JwtService;
import com.colorDetection.colorDetection.model.Users;
import com.colorDetection.colorDetection.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    public ResponseEntity<?> login(LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(),loginDto.getPassword()));
        if (authentication.isAuthenticated()){
            String token = jwtService.generateToken(authentication.getName());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid User");
        }
    }

    public ResponseEntity<?> register(Users users) {
        if (userRepo.findUserByEmail(users.getEmail()).isPresent()){
            return ResponseEntity.status(401).body("Email Exists");
        }
        if (userRepo.findUserByUsername(users.getUsername()).isPresent()){
            return ResponseEntity.status(402).body("Username Exists");
        }
        if (userRepo.findUserByPhoneNo(users.getPhoneNo()).isPresent()){
            return ResponseEntity.status(403).body("Phone Number Exists");
        }
        if (users.getPassword().length() < 8){
            return ResponseEntity.status(404).body("Password Should be least 8 Characters");
        }
        Users users1 = userRepo.save(users);
        return ResponseEntity.status(200).body(users1);
    }
}
