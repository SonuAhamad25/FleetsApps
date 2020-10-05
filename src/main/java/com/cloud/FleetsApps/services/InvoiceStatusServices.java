package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.InvoiceStatus;
import com.cloud.FleetsApps.repositories.InvoiceStatusRepository;

@Service
@Transactional
public class InvoiceStatusServices {
	@Autowired
	public InvoiceStatusRepository InvoiceStatusRepository;
	
	//return list of country
	public List<InvoiceStatus> getInvoiceStatuss() {
		
		return InvoiceStatusRepository.findAll();
	}


	//Save New Country
	public void save(InvoiceStatus InvoiceStatus) 
	{
		InvoiceStatusRepository.save(InvoiceStatus);
		
	}
	public Optional<InvoiceStatus> findById(int id) {

		return InvoiceStatusRepository.findById(id);
	}


	public void delete(int id) {
		InvoiceStatusRepository.deleteById(id);	
		
	}


}
