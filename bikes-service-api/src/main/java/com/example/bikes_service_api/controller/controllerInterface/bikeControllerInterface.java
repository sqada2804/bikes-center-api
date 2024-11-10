package com.example.bikes_service_api.controller.controllerInterface;


import com.example.bikes_service_api.common.constants.apiPathConstants;
import com.example.bikes_service_api.models.BikeModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RequestMapping(apiPathConstants.V1_ROUTE + apiPathConstants.BIKE_ROUTE)
public interface bikeControllerInterface {

    @PostMapping(value = "/createBike")
    ResponseEntity<BikeModel> createBike (
        @RequestBody BikeModel bikeRequest
    );

    @GetMapping(value = "/getBike/{bikeId}")
    ResponseEntity<BikeModel> getBikeById (
            @PathVariable Long bikeId
    );

    @GetMapping(value = "/getBikes")
    List<BikeModel> getBikes();

    @PutMapping(value = "/updateBike/{bikeId}")
    ResponseEntity<Void> updateBike (
            @RequestBody BikeModel bikeRequest,
            @PathVariable Long bikeId
    );

    @DeleteMapping(value = "/deleteBike/{bikeId}")
    ResponseEntity<Void> deleteBike (@PathVariable Long bikeId);
}
