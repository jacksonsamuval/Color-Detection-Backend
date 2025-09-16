package com.colorDetection.colorDetection.controller;

import com.colorDetection.colorDetection.model.Tanks;
import com.colorDetection.colorDetection.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getAllTankData")
    public ResponseEntity<?> getAllTankData(){
        try{
            return tankService.getAllTank();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).body("Server Error");
        }
    }

    @GetMapping("/getById/{tankName}")
    public ResponseEntity<?> getById(@PathVariable String tankName){
        try{
            return tankService.getTankByName(tankName);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(400).body("Server Error");
        }
    }
}
