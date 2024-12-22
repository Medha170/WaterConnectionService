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

    @PostMapping
    public ResponseEntity<WaterConnection> createWaterConnection(@RequestBody WaterConnection waterConnection){
        if (waterConnection.getPropertyId() == null){
            return ResponseEntity.badRequest().build();
        }
        WaterConnection createdConnection = waterConnectionService.createWaterConnection(waterConnection);
        return ResponseEntity.status(201).body(createdConnection);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterConnection> getWaterConnection(@PathVariable("id") Long id) {
        return waterConnectionService.getWaterConnectionById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaterConnection> updateWaterConnection(@PathVariable("id") Long id, @RequestBody WaterConnection waterConnection){
        try{
            WaterConnection updateConnection = waterConnectionService.updateWaterConnection(id, waterConnection);
            return ResponseEntity.ok(updateConnection);
        }
        catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
