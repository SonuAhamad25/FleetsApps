package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.FleetsApps.models.State;
@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
