package com.example.waterconnectionservice.Repository;

import com.example.waterconnectionservice.Model.WaterConnection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaterConnectionRepository extends JpaRepository<WaterConnection, Long> {
    @Override
    Optional<WaterConnection> findById(Long id);

    @Override
    WaterConnection save(WaterConnection waterConnection);

    Optional<WaterConnection> findByPropertyId(Long propertyId);

}
