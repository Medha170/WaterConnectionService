package com.example.waterconnectionservice.Controller;

import com.example.waterconnectionservice.Model.WaterConnection;
import com.example.waterconnectionservice.Service.WaterConnectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/water-connection/v1")
public class WaterConnectionController {

    private final WaterConnectionService waterConnectionService;

    public WaterConnectionController(WaterConnectionService waterConnectionService){
        this.waterConnectionService = waterConnectionService;
    }

    @PostMapping("/")
    public ResponseEntity<WaterConnection> createWaterConnection(@RequestBody WaterConnection waterConnection){
        if (waterConnection.getPropertyId() == null){
            return ResponseEntity.badRequest().build();
        }
        WaterConnection createdConnection = waterConnectionService.createWaterConnection(waterConnection);
        return ResponseEntity.status(201).body(createdConnection);
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<WaterConnection> getWaterConnectionByPropertyId(@PathVariable("propertyId") Long propertyId) {
        return waterConnectionService.getWaterConnectionByPropertyId(propertyId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<WaterConnection> updateWaterConnectionByPropertyId(
            @PathVariable("propertyId") Long propertyId,
            @RequestBody WaterConnection waterConnection) {
        try {
            WaterConnection updatedConnection = waterConnectionService.updateWaterConnectionByPropertyId(propertyId, waterConnection);
            return ResponseEntity.ok(updatedConnection);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
