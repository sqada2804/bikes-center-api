package com.example.bikes_service_api.service.InterfaceService;

import com.example.bikes_service_api.models.BikeModel;

import java.util.List;


public interface bikeServiceInterface {
    BikeModel createBike(BikeModel bikeRequest);
    BikeModel getBike(Long bikeId);
    List<BikeModel> getBikes();
    void updateBike(BikeModel bikeRequest, Long bikeId);
    void deleteBike(Long bikeId);
}
