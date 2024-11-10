package com.example.bikes_service_api.service.ImplementationService;

import com.example.bikes_service_api.models.BikeModel;
import com.example.bikes_service_api.repository.IBikeRepository;
import com.example.bikes_service_api.service.InterfaceService.bikeServiceInterface;
import com.example.bikes_service_api.utils.ErrorHandling.Errors.DataNotFoundException;
import com.example.bikes_service_api.utils.ErrorHandling.Errors.DataUpdateException;
import com.example.bikes_service_api.utils.ErrorHandling.Errors.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class bikeServiceImplementation implements bikeServiceInterface {

    private final IBikeRepository bikeRepository;

    public bikeServiceImplementation(IBikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public BikeModel createBike(BikeModel bikeRequest) {
        return Optional.of(bikeRequest)
                .map(this::mapToEntity)
                .map(bikeRepository::save)
                .orElseThrow(() -> new InvalidDataException("Error creating the bike"));
    }

    @Override
    public BikeModel getBike(Long bikeId) {
        return Optional.of(bikeId).flatMap(bikeRepository::findById)
                .orElseThrow(() -> new DataNotFoundException("Error finding the bike by id"));
    }

    @Override
    public List<BikeModel> getBikes() {
        return bikeRepository.findAll();
    }

    @Override
    public void updateBike(BikeModel bikeRequest, Long bikeId) {
        Optional.of(bikeId).map(this::getBike)
                .map(existingBike -> updateFieldsBike(existingBike, bikeRequest))
                .map(bikeRepository::save)
                .orElseThrow(() -> new DataUpdateException("Couldn´t update the Bike"));
    }

    @Override
    public void deleteBike(Long bikeId) {
    Optional.of(bikeId).map(this::getBike)
            .ifPresentOrElse(bikeRepository::delete, () -> { throw new DataNotFoundException("Bike Not Found with ID: " + bikeId); });
    }


    private BikeModel updateFieldsBike(BikeModel existingBike, BikeModel bikeRequest){
        existingBike.setModelBike(bikeRequest.getModelBike());
        existingBike.setBrandBike(bikeRequest.getBrandBike());
        existingBike.setPriceBike(bikeRequest.getPriceBike());
        existingBike.setStock(bikeRequest.getStock());
        return existingBike;
    }

    private BikeModel mapToEntity(BikeModel bikeRequest){
        return BikeModel.builder()
                .modelBike(bikeRequest.getModelBike())
                .brandBike(bikeRequest.getBrandBike())
                .priceBike(bikeRequest.getPriceBike()).build();
    }
}
