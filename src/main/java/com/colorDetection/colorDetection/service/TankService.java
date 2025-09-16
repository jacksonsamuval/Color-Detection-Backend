package com.colorDetection.colorDetection.service;

import com.colorDetection.colorDetection.model.Tanks;
import com.colorDetection.colorDetection.repo.TankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TankService {
    @Autowired
    private TankRepo tankRepo;
    public ResponseEntity<?> saveTankData(Tanks tanks) {
        Tanks tanks1 = tankRepo.save(tanks);
        return ResponseEntity.status(200).body(tanks1);
    }

    public ResponseEntity<?> getAllTank() {
        List<Tanks> tanks = tankRepo.findAll();
        return ResponseEntity.status(200).body(tanks);
    }

    public ResponseEntity<?> getTankByName(String tankName) {
        Optional<Tanks> tanks = tankRepo.findByTankNameIgnoreCaseTrim(tankName);
        return ResponseEntity.status(200).body(tanks);
    }
}
