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
import com.cloud.FleetsApps.models.Country;
import com.cloud.FleetsApps.models.State;
import com.cloud.FleetsApps.services.ClientServies;
import com.cloud.FleetsApps.services.CountryService;

import com.cloud.FleetsApps.services.StateServices;

@Controller
public class ClientController {
	
	@Autowired
	private CountryService countryservice;
	
	@Autowired
	private  StateServices stateservices;
	
	@Autowired
	public ClientServies clientServies;
	
	
	
	
	@GetMapping("/clients")
	public String Getclients(Model model)
	{
		
		//This use for dynomic drowndrop
		List<State> stateList=stateservices.getState();
		model.addAttribute("states",stateList);
		
		//This use for dynomic drowndrop
		List<Country> countryList=countryservice.getCountries();
		model.addAttribute("countries",countryList);
		
		List<Client> ClientList=clientServies.getclients();
		model.addAttribute("clients",ClientList);
		
	
		return "client";
	}
	
    @PostMapping("/clients/addNew")
    public String addNew(Client Client) 
    {
    	clientServies.save(Client);
		return "redirect:/clients";
    }
   // fetch the id on edit page
    @RequestMapping("/clients/findById")
    @ResponseBody
    public Optional<Client>  findById(int id) {
        return clientServies.findById(id);
    }
    
    
    //this method use for  save edit data
    @RequestMapping(value="/clients/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(Client Client) { 
    	clientServies.save(Client);	
    	 return "redirect:/clients";
    }
    
  //this method use for  save edit data
    @RequestMapping(value="/clients/delete", method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(int id) { 
    	clientServies.delete(id);	
    	 return "redirect:/clients";
    }
   

}
