package com.colorDetection.colorDetection.controller;

import com.colorDetection.colorDetection.dto.SaveColorDto;
import com.colorDetection.colorDetection.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/colors")
public class ColorController {
    @Autowired
    private ColorService colorService;
    @PostMapping("/saveTankColor")
    public ResponseEntity<?> saveColors(@RequestBody SaveColorDto colors){
        try{
            return colorService.saveColors(colors);
        } catch (Exception e){
            return ResponseEntity.status(400).body("Server Error");
        }
    }
    @GetMapping("/getAllTankColors")
    public ResponseEntity<?> getAllColors(){
        try{
            return colorService.getAllTankColors();
        } catch (Exception e){
            return ResponseEntity.status(400).body("Server Error");
        }
    }
    @GetMapping("/getColorsByTankName/{tankName}")
    public ResponseEntity<?> getColorsByTankName(@PathVariable String tankName){
        try{
            return colorService.getColorsByTankName(tankName);
        } catch (Exception e){
            return ResponseEntity.status(400).body("Server Error");
        }
    }
}
