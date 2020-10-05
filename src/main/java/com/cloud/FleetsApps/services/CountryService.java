package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.Country;
import com.cloud.FleetsApps.repositories.CountryRepository;

@Service
@Transactional
public class CountryService 
{
@Autowired
private CountryRepository countryRepository;

//return list of country
public List<Country> getCountries() {
	
	return countryRepository.findAll();
}


//Save New Country
public void save(Country country) 
{
	countryRepository.save(country);
	
}


public Optional<Country> findById(int id) {

	return countryRepository.findById(id);
}


public void delete(int id) {
	countryRepository.deleteById(id);	
	
}


}
	
	
	


