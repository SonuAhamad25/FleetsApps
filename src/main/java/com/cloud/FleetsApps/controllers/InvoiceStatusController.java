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

import com.cloud.FleetsApps.models.Country;
import com.cloud.FleetsApps.models.InvoiceStatus;
import com.cloud.FleetsApps.models.State;
import com.cloud.FleetsApps.services.CountryService;
import com.cloud.FleetsApps.services.InvoiceStatusServices;
import com.cloud.FleetsApps.services.StateServices;

@Controller
public class InvoiceStatusController {
	
	@Autowired
	private CountryService countryservice;
	
	@Autowired
	private  StateServices stateservices;
	
	@Autowired
	private InvoiceStatusServices InvoiceStatusservies;
	
	@GetMapping("/invoice_status")
	public String GetCountries(Model model)
	{
		
		
		//This use for dynomic drowndrop
				List<State> stateList=stateservices.getState();
				model.addAttribute("states",stateList);
				
				//This use for dynomic drowndrop
				List<Country> countryList=countryservice.getCountries();
				model.addAttribute("countries",countryList);
				
		List<InvoiceStatus> InvoiceStatusList=InvoiceStatusservies.getInvoiceStatuss();
		model.addAttribute("InvoiceStatus",InvoiceStatusList);
		
	
		return "invoiceStatus";
	}
	
    @PostMapping("/invoice_status/addNew")
    public String addNew(InvoiceStatus InvoiceStatus) 
    {
    	InvoiceStatusservies.save(InvoiceStatus);
		return "redirect:/invoice_status";
    }
    
    
 // fetch the id on edit page
    @RequestMapping("/invoice_status/findById")
    @ResponseBody
	    public Optional<InvoiceStatus>  findById(int id) {
	        return InvoiceStatusservies.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/invoice_status/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(InvoiceStatus locataion) { 
    	InvoiceStatusservies.save(locataion);	
    	 return "redirect:/InvoiceStatus";
    }

	
	 @RequestMapping(value="/invoice_status/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 InvoiceStatusservies.delete(id);
		 return "redirect:/invoice_status";
	 }


}
