package com.colorDetection.colorDetection.controller;

import com.colorDetection.colorDetection.model.Colors;
import com.colorDetection.colorDetection.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
