package com.example.waterconnectionservice.Service;

import com.example.waterconnectionservice.Model.WaterConnection;

import java.util.Optional;

public interface WaterConnectionService {

    WaterConnection createWaterConnection(WaterConnection waterConnection);

    Optional<WaterConnection> getWaterConnectionById(Long id);

    WaterConnection updateWaterConnection(Long id, WaterConnection waterConnection);

}
