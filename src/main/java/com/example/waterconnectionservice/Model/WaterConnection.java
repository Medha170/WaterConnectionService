package com.example.waterconnectionservice.Model;

import jakarta.persistence.*;
//import lombok.*;
import java.util.UUID;

@Entity
public class WaterConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "water_connection_id", nullable = false, unique = true)
    private String waterConnectionId = UUID.randomUUID().toString(); // Automatically set UUID

    @Column(name = "property_id", nullable = false)
    private Long propertyId;

    @Column(name = "description")
    private String description;

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
