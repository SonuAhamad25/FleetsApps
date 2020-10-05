package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.VehicleMake;
import com.cloud.FleetsApps.repositories.VehicleMakeRepository;
@Service
@Transactional
public class VehicleMakeServices {
	
	@Autowired
	public VehicleMakeRepository VehicleMakeRepository;
	
	//return list of country
	public List<VehicleMake> getVehicleMakes() {
		
		return VehicleMakeRepository.findAll();
	}


	//Save New Country
	public void save(VehicleMake VehicleMake) 
	{
		VehicleMakeRepository.save(VehicleMake);
		
	}
	public Optional<VehicleMake> findById(int id) {

		return VehicleMakeRepository.findById(id);
	}


	public void delete(int id) {
		VehicleMakeRepository.deleteById(id);	
		
	}


}
