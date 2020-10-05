package com.cloud.FleetsApps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloud.FleetsApps.models.Invoice;



public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
