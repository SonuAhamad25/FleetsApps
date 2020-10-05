package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.FleetsApps.models.EmployeeType;

public interface EmployeeTypesRepository extends JpaRepository<EmployeeType, Integer> {

}
