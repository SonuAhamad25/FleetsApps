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
import com.cloud.FleetsApps.models.Location;
import com.cloud.FleetsApps.models.State;
import com.cloud.FleetsApps.services.CountryService;
import com.cloud.FleetsApps.services.LocationServies;
import com.cloud.FleetsApps.services.StateServices;




@Controller
public class LocationController {
	
	
	@Autowired
	private CountryService countryservice;
	
	@Autowired
	private  StateServices stateservices;
	
	@Autowired
	private LocationServies locationservies;
	
	@GetMapping("/locations")
	public String GetCountries(Model model)
	{
		//This use for dynomic drowndrop
				List<State> stateList=stateservices.getState();
				model.addAttribute("states",stateList);
				
				//This use for dynomic drowndrop
				List<Country> countryList=countryservice.getCountries();
				model.addAttribute("countries",countryList);
		
		List<Location> locationList=locationservies.getLocations();
		model.addAttribute("locations",locationList);
		
	
		return "location";
	}
	
    @PostMapping("/locations/addNew")
    public String addNew(Location location) 
    {
    	locationservies.save(location);
		return "redirect:/locations";
    }
    
    
 // fetch the id on edit page
    @RequestMapping("/location/findById")
    @ResponseBody
	    public Optional<Location>  findById(int id) {
	        return locationservies.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/location/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(Location locataion) { 
    	locationservies.save(locataion);	
    	 return "redirect:/locations";
    }

	
	 @RequestMapping(value="/location/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 locationservies.delete(id);
		 return "redirect:/locations";
	 }

}
