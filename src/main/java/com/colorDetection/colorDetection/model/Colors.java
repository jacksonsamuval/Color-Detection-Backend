package com.colorDetection.colorDetection.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tank_id", nullable = false)
    private Tanks tank;
    private int r;
    private int g;
    private int b;
    private String hex;
    private String colorName;
    private LocalDateTime timeStamp;

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Tanks getTank() {
        return tank;
    }

    public void setTank(Tanks tank) {
        this.tank = tank;
    }
}
