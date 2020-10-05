package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.Location;
import com.cloud.FleetsApps.repositories.LocationRepository;


@Service
@Transactional
public class LocationServies {
	
	@Autowired
	public LocationRepository locationRepository;
	
	//return list of country
	public List<Location> getLocations() {
		
		return locationRepository.findAll();
	}


	//Save New Country
	public void save(Location location) 
	{
		locationRepository.save(location);
		
	}
	public Optional<Location> findById(int id) {

		return locationRepository.findById(id);
	}


	public void delete(int id) {
		locationRepository.deleteById(id);	
		
	}

	

}
