package com.colorDetection.colorDetection.controller;

import com.colorDetection.colorDetection.dto.LoginDto;
import com.colorDetection.colorDetection.model.Users;
import com.colorDetection.colorDetection.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;
    @GetMapping("/hello")
    public void sayHello(){
        System.out.println("Hello");
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> loginToSystem(@RequestBody LoginDto loginDto){
        try {
            return homeService.login(loginDto);
        } catch (Exception e){
            return ResponseEntity.status(400).body("Server Error");
        }
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestBody Users users){
        try {
            return homeService.register(users);
        } catch (Exception e){
            return ResponseEntity.status(400).body("Server Error");
        }
    }

}
