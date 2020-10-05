package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.EmployeeType;

import com.cloud.FleetsApps.repositories.EmployeeTypesRepository;
@Service
@Transactional
public class EmployeeTypesServices {
	@Autowired
	public EmployeeTypesRepository EmployeeTypesRepository;
	
	//return list of country
	public List<EmployeeType> getEmployeeTypess() {
		
		return EmployeeTypesRepository.findAll();
	}


	//Save New Country
	public void save(EmployeeType EmployeeTypes) 
	{
		EmployeeTypesRepository.save(EmployeeTypes);
		
	}
	public Optional<EmployeeType> findById(int id) {

		return EmployeeTypesRepository.findById(id);
	}


	public void delete(int id) {
		EmployeeTypesRepository.deleteById(id);	
		
	}


}
