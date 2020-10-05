package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.VehicleModel;
import com.cloud.FleetsApps.repositories.VehicleModelRepository;
@Service
@Transactional
public class VehicleModelsServices {
	@Autowired
	public VehicleModelRepository VehicleModelRepository;
	
	//return list of country
	public List<VehicleModel> getVehicleModels() {
		
		return VehicleModelRepository.findAll();
	}


	//Save New Country
	public void save(VehicleModel VehicleModel) 
	{
		VehicleModelRepository.save(VehicleModel);
		
	}
	public Optional<VehicleModel> findById(int id) {

		return VehicleModelRepository.findById(id);
	}


	public void delete(int id) {
		VehicleModelRepository.deleteById(id);	
		
	}


}
