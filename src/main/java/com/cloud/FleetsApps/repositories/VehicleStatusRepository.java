package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.FleetsApps.models.VehicleStatus;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Integer> {

}
