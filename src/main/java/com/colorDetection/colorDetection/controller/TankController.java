package com.colorDetection.colorDetection.controller;

import com.colorDetection.colorDetection.model.Tanks;
import com.colorDetection.colorDetection.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tank")
public class TankController {
    @Autowired
    private TankService tankService;
    @PostMapping("/saveData")
    public ResponseEntity<?> saveTankData(@RequestBody Tanks tanks){
        try{
            return tankService.saveTankData(tanks);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).body("Server Error");
        }
    }
}
