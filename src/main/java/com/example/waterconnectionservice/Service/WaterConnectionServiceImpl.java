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
    public Optional<WaterConnection> getWaterConnectionById(Long id){
        return waterConnectionRepository.findById(id);
    }

    @Override
    public WaterConnection updateWaterConnection(Long id, WaterConnection waterConnection){
        return waterConnectionRepository.findById(id).map(existingConnection -> {
            existingConnection.setPropertyId(waterConnection.getPropertyId());
            existingConnection.setDescription(waterConnection.getDescription());
            return waterConnectionRepository.save(existingConnection);
        }).orElseThrow(() -> new RuntimeException("Connection not found"));
    }
}
