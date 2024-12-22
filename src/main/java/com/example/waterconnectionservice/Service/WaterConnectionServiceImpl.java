package com.example.waterconnectionservice.Service;

import com.example.waterconnectionservice.Model.WaterConnection;
import com.example.waterconnectionservice.Repository.WaterConnectionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class WaterConnectionServiceImpl implements WaterConnectionService{

    private final WaterConnectionRepository waterConnectionRepository;

    WaterConnectionServiceImpl(WaterConnectionRepository waterConnectionRepository){
        this.waterConnectionRepository = waterConnectionRepository;
    }

    @Override
    public WaterConnection createWaterConnection(WaterConnection waterConnection){
        waterConnection.setWaterConnectionId(UUID.randomUUID().toString());
        return waterConnectionRepository.save(waterConnection);
    }

    @Override
    public Optional<WaterConnection> getWaterConnectionByPropertyId(Long propertyId) {
        return waterConnectionRepository.findByPropertyId(propertyId);
    }

    @Override
    public WaterConnection updateWaterConnectionByPropertyId(Long propertyId, WaterConnection waterConnection) {
        return waterConnectionRepository.findByPropertyId(propertyId).map(existingConnection -> {
            existingConnection.setDescription(waterConnection.getDescription());
            return waterConnectionRepository.save(existingConnection);
        }).orElseThrow(() -> new RuntimeException("Connection not found"));
    }
}
