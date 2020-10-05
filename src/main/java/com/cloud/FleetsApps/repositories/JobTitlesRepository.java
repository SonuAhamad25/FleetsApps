package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.FleetsApps.models.JobTitle;

public interface JobTitlesRepository extends JpaRepository<JobTitle, Integer> {

}
