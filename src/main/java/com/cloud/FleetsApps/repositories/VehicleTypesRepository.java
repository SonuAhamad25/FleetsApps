package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.FleetsApps.models.VehicleType;

public interface VehicleTypesRepository extends JpaRepository<VehicleType, Integer> {

}
