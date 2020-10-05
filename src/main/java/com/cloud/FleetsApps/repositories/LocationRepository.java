package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.FleetsApps.models.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
