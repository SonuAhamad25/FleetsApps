package com.cloud.FleetsApps.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.FleetsApps.models.Client;

import com.cloud.FleetsApps.models.Invoice;

import com.cloud.FleetsApps.services.ClientServies;
import com.cloud.FleetsApps.services.InvoiceService;
import com.cloud.FleetsApps.services.InvoiceStatusServices;

@Controller
public class InvoiceController {
	
	@Autowired
    private  InvoiceService invoiceservices;
	@Autowired
	private ClientServies clientservice;
	@Autowired
	private InvoiceStatusServices InvoiceStatusservies;


	@GetMapping("/invoice")
	public String GetStates(Model model)
	{
		List<Invoice> invoiceList=invoiceservices.getInvoice();
		model.addAttribute("invoices",invoiceList);
		
		//This use for dynomic drowndrop
		List<Client> clientList=clientservice.getclients();
		model.addAttribute("clients",clientList);
		
		model.addAttribute("invoiceStatus",InvoiceStatusservies.getInvoiceStatuss());//we can write this type
	
		return "invoice";
	}
	
	// fetch the id on edit page
    @RequestMapping("/invoice/findById")
    @ResponseBody
	    public Optional<Invoice>  findById(int id) {
	        return invoiceservices.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/invoice/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(Invoice invoice) { 
    	invoiceservices.save(invoice);	
    	 return "redirect:/invoice";
    }

	 @PostMapping("/invoice/addNew")
	    public String addNew(Invoice invoice) 
	    {
		 invoiceservices.save(invoice);
			return "redirect:/invoice";
	    }
	 @RequestMapping(value="/invoice/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 invoiceservices.delete(id);
		 return "redirect:/invoice";
	 }

}
