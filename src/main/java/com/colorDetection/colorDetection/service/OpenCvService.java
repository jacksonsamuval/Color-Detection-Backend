package com.colorDetection.colorDetection.service;

import com.colorDetection.colorDetection.model.Colors;
import com.colorDetection.colorDetection.model.OpenCvColor;
import com.colorDetection.colorDetection.model.Tanks;
import com.colorDetection.colorDetection.repo.OpenCvColorRepo;
import com.colorDetection.colorDetection.repo.TankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OpenCvService {
    @Autowired
    private OpenCvColorRepo openCvColorRepo;
    @Autowired
    private TankRepo tankRepo;
    public ResponseEntity<?> saveColor(String tankName, String hex, LocalDateTime dateTime, String colorName, MultipartFile file) throws IOException {
        OpenCvColor openCvColor = new OpenCvColor();
        Optional<Tanks> tanks = tankRepo.findByTankNameIgnoreCaseTrim(tankName);
        if (tanks.isEmpty()){
            return ResponseEntity.status(401).body("Invalid Tank Name");
        }
        openCvColor.setHex(hex);
        openCvColor.setColorName(colorName);
        openCvColor.setTank(tanks.get());
        openCvColor.setLocalDateTime(dateTime);
        openCvColor.setImageData(file.getBytes());
        OpenCvColor cvColor = openCvColorRepo.save(openCvColor);
        return ResponseEntity.status(200).body(cvColor);
    }

    public ResponseEntity<?> getAllColors() {
        List<OpenCvColor> colors = openCvColorRepo.findAll();
        return ResponseEntity.status(200).body(colors);
    }

    public ResponseEntity<?> getColorByTankName(String tankName) {
        Optional<Tanks> tanks = tankRepo.findByTankNameIgnoreCaseTrim(tankName);
        if (tanks.isEmpty()){
            return ResponseEntity.status(401).body("Invalid Tank Name");
        }
        List<OpenCvColor> colors = openCvColorRepo.findByTank(tanks);
        if (colors.isEmpty()){
            return ResponseEntity.status(402).body("No Data Collected");
        }
        return ResponseEntity.status(200).body(colors);
    }
}
