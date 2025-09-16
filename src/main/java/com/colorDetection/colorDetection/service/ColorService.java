package com.colorDetection.colorDetection.service;

import com.colorDetection.colorDetection.dto.SaveColorDto;
import com.colorDetection.colorDetection.model.Colors;
import com.colorDetection.colorDetection.model.Tanks;
import com.colorDetection.colorDetection.repo.ColorsRepo;
import com.colorDetection.colorDetection.repo.TankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorService {
    @Autowired
    private ColorsRepo colorsRepo;
    @Autowired
    private TankRepo tankRepo;
    public ResponseEntity<?> saveColors(SaveColorDto colors) {
        try {
            Colors saveData = new Colors();
            Optional<Tanks> tanks = tankRepo.findByTankNameIgnoreCaseTrim(colors.getTankName());
            if (tanks.isPresent()){
                saveData.setTank(tanks.get());
            } else {
                return ResponseEntity.status(401).body("Invalid Tank Name");
            }
            saveData.setColorName(colors.getColorName());
            saveData.setR(colors.getR());
            saveData.setG(colors.getG());
            saveData.setB(colors.getB());
            saveData.setHex(colors.getHex());
            saveData.setTimeStamp(colors.getTimeStamp());
            Colors saved = colorsRepo.save(saveData);

            System.out.println("<-------------------------------------------->");
            System.out.println("Tank Name :" + saved.getTank().getTankName());
            System.out.println("R :" +saved.getR());
            System.out.println("G :" +saved.getG());
            System.out.println("B :" +saved.getB());
            System.out.println("HEX :" +saved.getHex());
            System.out.println("Color Name :" +saved.getColorName());
            System.out.println("Timestamp :" +saved.getTimeStamp());
            System.out.println("<-------------------------------------------->");
            System.out.println("Saved Successfully!");
            System.out.println("<-------------------------------------------->");

            return ResponseEntity.status(200).body(saved);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error saving color data");
        }
    }
}
