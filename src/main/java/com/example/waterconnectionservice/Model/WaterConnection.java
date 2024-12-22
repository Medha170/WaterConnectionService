package com.example.waterconnectionservice.Model;

import jakarta.persistence.*;
//import lombok.*;
import java.util.UUID;

@Entity
public class WaterConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String waterConnectionId = UUID.randomUUID().toString(); // Automatically set UUID
    private Long propertyId;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWaterConnectionId() {
        return waterConnectionId;
    }

    public void setWaterConnectionId(String waterConnectionId) {
        this.waterConnectionId = waterConnectionId;
    }

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
