package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.Invoice;
import com.cloud.FleetsApps.repositories.InvoiceRepository;
@Service
@Transactional
public class InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;

	public List<Invoice> getInvoice() {
		// TODO Auto-generated method stub
		return invoiceRepository.findAll();
	}

	public Optional<Invoice> findById(int id) {
		// TODO Auto-generated method stub
		return invoiceRepository.findById(id);
	}

	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
		
	}

	public void delete(int id) {
		invoiceRepository.deleteById(id);
		
	}
	
	

	
	}


	

	


