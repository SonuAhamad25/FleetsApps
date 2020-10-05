package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.FleetsApps.models.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
