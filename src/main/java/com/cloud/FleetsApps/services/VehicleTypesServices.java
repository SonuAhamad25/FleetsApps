package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.VehicleType;
import com.cloud.FleetsApps.repositories.VehicleTypesRepository;
@Service
@Transactional
public class VehicleTypesServices {
	@Autowired
	public VehicleTypesRepository VehicleTypesRepository;
	
	//return list of country
	public List<VehicleType> getVehicleTypes() {
		
		return VehicleTypesRepository.findAll();

	}
	//Save New Country
	public void save(VehicleType VehicleTypes) 
	{
		VehicleTypesRepository.save(VehicleTypes);
		
	}
	public Optional<VehicleType> findById(int id) {

		return VehicleTypesRepository.findById(id);
	}


	public void delete(int id) {
		VehicleTypesRepository.deleteById(id);	
		
	}


}
