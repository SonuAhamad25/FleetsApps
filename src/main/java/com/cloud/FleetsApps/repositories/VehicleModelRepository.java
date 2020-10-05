package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.FleetsApps.models.VehicleModel;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer> {

}
