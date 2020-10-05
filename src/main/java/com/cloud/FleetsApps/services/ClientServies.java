package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.Client;
import com.cloud.FleetsApps.repositories.ClientRepositories;

@Service
@Transactional
public class ClientServies {
	@Autowired
	public ClientRepositories  clientRepository;
	//return list of Client
	public List<Client> getclients() {
		
		return clientRepository.findAll();
	}


	//Save New Client
	public void save(Client Client) 
	{
		clientRepository.save(Client);
		
	}


	public Optional<Client> findById(int id) {

		return clientRepository.findById(id);
	}


	public void delete(int id) {
		clientRepository.deleteById(id);	
		
	}


	


}
