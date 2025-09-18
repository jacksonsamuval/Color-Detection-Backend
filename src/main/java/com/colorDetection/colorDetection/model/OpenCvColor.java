package com.colorDetection.colorDetection.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OpenCvColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "tank_id", nullable = false)
    private Tanks tank;
    public String hex;
    public String colorName;
    public LocalDateTime localDateTime;
    @Lob
    @Column(columnDefinition =  "LONGBLOB")
    public byte[] imageData;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Tanks getTank() {
        return tank;
    }

    public void setTank(Tanks tank) {
        this.tank = tank;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}
