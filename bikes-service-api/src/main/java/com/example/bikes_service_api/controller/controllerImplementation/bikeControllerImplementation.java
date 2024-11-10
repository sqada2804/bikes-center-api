package com.example.bikes_service_api.controller.controllerImplementation;

import com.example.bikes_service_api.controller.controllerInterface.bikeControllerInterface;
import com.example.bikes_service_api.models.BikeModel;
import com.example.bikes_service_api.service.InterfaceService.bikeServiceInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class bikeControllerImplementation implements bikeControllerInterface {

    private final bikeServiceInterface bikeService;

    public bikeControllerImplementation(bikeServiceInterface bikeService) {
        this.bikeService = bikeService;
    }

    @Override
    public ResponseEntity<BikeModel> createBike(BikeModel bikeRequest) {
        return ResponseEntity.ok(bikeService.createBike(bikeRequest));
    }

    @Override
    public ResponseEntity<BikeModel> getBikeById(Long bikeId) {
        return ResponseEntity.ok(bikeService.getBike(bikeId));
    }

    @Override
    public List<BikeModel> getBikes() {
        return bikeService.getBikes();
    }

    @Override
    public ResponseEntity<Void> updateBike(BikeModel bikeRequest, Long bikeId) {
        bikeService.updateBike(bikeRequest, bikeId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteBike(Long bikeId) {
        bikeService.deleteBike(bikeId);
        return ResponseEntity.noContent().build();
    }
}
