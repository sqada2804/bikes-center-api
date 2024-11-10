package com.example.bikes_service_api.repository;

import com.example.bikes_service_api.models.BikeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBikeRepository extends JpaRepository<BikeModel, Long> {
}
