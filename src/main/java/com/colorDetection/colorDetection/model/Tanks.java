package com.colorDetection.colorDetection.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tanks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tankName;
    private String tankCapacity;
    private String tankDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTankName() {
        return tankName;
    }

    public void setTankName(String tankName) {
        this.tankName = tankName;
    }

    public String getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(String tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String getTankDescription() {
        return tankDescription;
    }

    public void setTankDescription(String tankDescription) {
        this.tankDescription = tankDescription;
    }
}
