package com.colorDetection.colorDetection.service;

import com.colorDetection.colorDetection.model.Tanks;
import com.colorDetection.colorDetection.repo.TankRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TankService {
    @Autowired
    private TankRepo tankRepo;
    public ResponseEntity<?> saveTankData(Tanks tanks) {
        Tanks tanks1 = tankRepo.save(tanks);
        return ResponseEntity.status(200).body(tanks1);
    }
}
