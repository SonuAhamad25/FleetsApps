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


import com.cloud.FleetsApps.models.VehicleMake;
import com.cloud.FleetsApps.services.VehicleMakeServices;

@Controller
public class VehicleMakeController {
	@Autowired
	private VehicleMakeServices VehicleMakeservies;
	
	@GetMapping("/vehicle_makes")
	public String GetCountries(Model model)
	{
		
		
		List<VehicleMake> VehicleMakeList=VehicleMakeservies.getVehicleMakes();
		model.addAttribute("VehicleMakes",VehicleMakeList);
		
	
		return "vehicleMake";
	}
	
    @PostMapping("/vehicle_makes/addNew")
    public String addNew(VehicleMake VehicleMake) 
    {
    	VehicleMakeservies.save(VehicleMake);
		return "redirect:/vehicle_makes";
    }
    
    
 // fetch the id on edit page
    @RequestMapping("/vehicle_makes/findById")
    @ResponseBody
	    public Optional<VehicleMake>  findById(int id) {
	        return VehicleMakeservies.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/vehicle_makes/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(VehicleMake VehicleMake) { 
    	VehicleMakeservies.save(VehicleMake);	
    	 return "redirect:/vehicle_makes";
    }

	
	 @RequestMapping(value="/vehicle_makes/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 VehicleMakeservies.delete(id);
		 return "redirect:/vehicle_makes";
	 }


}
