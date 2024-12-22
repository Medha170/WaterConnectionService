package com.example.waterconnectionservice.Service;

import com.example.waterconnectionservice.Model.WaterConnection;

import java.util.Optional;

public interface WaterConnectionService {

    WaterConnection createWaterConnection(WaterConnection waterConnection);

    Optional<WaterConnection> getWaterConnectionByPropertyId(Long propertyId);

    WaterConnection updateWaterConnectionByPropertyId(Long id, WaterConnection waterConnection);

}
