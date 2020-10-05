package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.State;
import com.cloud.FleetsApps.repositories.StateRepository;
@Service
@Transactional
public class StateServices {
	@Autowired
	private StateRepository stateRepository;

	public List<State> getState() 
	{
		
		return stateRepository.findAll();
	}

	public void save(State state) {
		stateRepository.save(state);
		
	}

	public Optional<State> findById(int id) {
		
		return stateRepository.findById(id) ;
	}

	public void delete(int id) {
		
		 stateRepository.deleteById(id);
	}

	

}
