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
import com.cloud.FleetsApps.models.VehicleStatus;
import com.cloud.FleetsApps.services.VehicleStatusServices;


@Controller
public class VehicleStatusController {
	@Autowired
	private VehicleStatusServices VehicleStatusservies;
	
	@GetMapping("/vehicle_values")
	public String GetCountries(Model model)
	{
		
		
		List<VehicleStatus> VehicleStatusList=VehicleStatusservies.getVehicleStatuss();
		model.addAttribute("VehicleStatuss",VehicleStatusList);
		
	
		return "vehicleStatus";
	}
	
    @PostMapping("/vehicle_values/addNew")
    public String addNew(VehicleStatus VehicleStatus) 
    {
    	VehicleStatusservies.save(VehicleStatus);
		return "redirect:/vehicle_values";
    }
    
    
 // fetch the id on edit page
    @RequestMapping("/vehicle_values/findById")
    @ResponseBody
	    public Optional<VehicleStatus>  findById(int id) {
	        return VehicleStatusservies.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/vehicle_values/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(VehicleStatus locataion) { 
    	VehicleStatusservies.save(locataion);	
    	 return "redirect:/vehicle_values";
    }

	
	 @RequestMapping(value="/vehicle_values/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 VehicleStatusservies.delete(id);
		 return "redirect:/vehicle_values";
	 }


}
