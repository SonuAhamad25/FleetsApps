package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.VehicleStatus;
import com.cloud.FleetsApps.repositories.VehicleStatusRepository;
@Service
@Transactional
public class VehicleStatusServices {
	@Autowired
	public VehicleStatusRepository VehicleStatusRepository;
	
	//return list of country
	public List<VehicleStatus> getVehicleStatuss() {
		
		return VehicleStatusRepository.findAll();
	}


	//Save New Country
	public void save(VehicleStatus VehicleStatus) 
	{
		VehicleStatusRepository.save(VehicleStatus);
		
	}
	public Optional<VehicleStatus> findById(int id) {

		return VehicleStatusRepository.findById(id);
	}


	public void delete(int id) {
		VehicleStatusRepository.deleteById(id);	
		
	}


}
