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
import com.cloud.FleetsApps.services.CountryService;
@Controller
public class CountryController 
{
	@Autowired
	private CountryService countryservice;
	
	
	@GetMapping("/countries")
	public String GetCountries(Model model)
	{
		List<Country> countryList=countryservice.getCountries();
		model.addAttribute("countries",countryList);
	
		return "country";
	}
	
    @PostMapping("/countries/addNew")
    public String addNew(Country country) 
    {
		countryservice.save(country);
		return "redirect:/countries";
    }
   // fetch the id on edit page
    @RequestMapping("/countries/findById")
    @ResponseBody
    public Optional<Country>  findById(int id) {
        return countryservice.findById(id);
    }
    
    
    //this method use for  save edit data
    @RequestMapping(value="/countries/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(Country country) { 
    	 countryservice.save(country);	
    	 return "redirect:/countries";
    }
    
  //this method use for  save edit data
    @RequestMapping(value="/countries/delete", method={RequestMethod.GET,RequestMethod.DELETE})
    public String delete(int id) { 
    	 countryservice.delete(id);	
    	 return "redirect:/countries";
    }
   
     
}


