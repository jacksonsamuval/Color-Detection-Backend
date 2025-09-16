package com.colorDetection.colorDetection.service;

import com.colorDetection.colorDetection.model.Colors;
import com.colorDetection.colorDetection.repo.ColorsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColorService {
    @Autowired
    private ColorsRepo colorsRepo;
    public void saveColors(Colors colors) {
        try {
            colorsRepo.save(colors);
            System.out.println("Saved Successfully!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
