package com.colorDetection.colorDetection.controller;

import com.colorDetection.colorDetection.service.OpenCvService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/opencv")
public class OpenCvController {
    @Autowired
    private OpenCvService openCvService;
    @PostMapping("/save")
    public ResponseEntity<?> getFromOpenCv(@RequestParam String tankName,
                                           @RequestParam String hex,
                                           @RequestParam LocalDateTime dateTime,
                                           @RequestParam String colorName,
                                           @RequestParam MultipartFile file,
                                           HttpServletRequest request){
        try {
            return openCvService.saveColor(tankName,hex,dateTime,colorName,file);
        } catch (Exception e){
            return ResponseEntity.status(400).body("Server Error");
        }
    }

    @GetMapping("/getAllColors")
    public ResponseEntity<?> getAllColors(){
        try{
            return openCvService.getAllColors();
        } catch (Exception e) {
            return ResponseEntity.status(200).body("Server Error");
        }
    }

    @GetMapping("/getByTankName/{tankName}")
    public ResponseEntity<?> getColorByTankName(@PathVariable String tankName){
        try{
            return openCvService.getColorByTankName(tankName);
        } catch (Exception e) {
            return ResponseEntity.status(200).body("Server Error");
        }
    }
}
