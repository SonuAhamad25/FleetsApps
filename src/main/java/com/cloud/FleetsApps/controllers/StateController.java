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
import com.cloud.FleetsApps.models.State;
import com.cloud.FleetsApps.services.CountryService;
import com.cloud.FleetsApps.services.StateServices;
@Controller
public class StateController {
	@Autowired
    private  StateServices stateservices;
	@Autowired
	private CountryService countryservice;


	@GetMapping("/states")
	public String GetStates(Model model)
	{
		List<State> stateList=stateservices.getState();
		model.addAttribute("states",stateList);
		
		//This use for dynomic drowndrop
		List<Country> countryList=countryservice.getCountries();
		model.addAttribute("countries",countryList);
	
		return "state";
	}
	
	// fetch the id on edit page
    @RequestMapping("/states/findById")
    @ResponseBody
	    public Optional<State>  findById(int id) {
	        return stateservices.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/states/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(State state) { 
    	stateservices.save(state);	
    	 return "redirect:/states";
    }

	 @PostMapping("/states/addNew")
	    public String addNew(State state) 
	    {
		 stateservices.save(state);
			return "redirect:/states";
	    }
	 @RequestMapping(value="/states/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 stateservices.delete(id);
		 return "redirect:/states";
	 }
}
