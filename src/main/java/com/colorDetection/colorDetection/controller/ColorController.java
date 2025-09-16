package com.colorDetection.colorDetection.controller;
import com.colorDetection.colorDetection.model.Colors;
import com.colorDetection.colorDetection.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colors")
public class ColorController {
    @Autowired
    private ColorService colorService;
    @PostMapping("/getDemoColors")
    public void getColors(@RequestBody Colors colors){
        System.out.println(colors.getContainerNo());
        System.out.println(colors.getR());
        System.out.println(colors.getG());
        System.out.println(colors.getB());
        System.out.println(colors.getHex());
        System.out.println(colors.getColorName());
        System.out.println(colors.getTimeStamp());
        colorService.saveColors(colors);
    }
}
