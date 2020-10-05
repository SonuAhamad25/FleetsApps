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
import com.cloud.FleetsApps.models.VehicleType;
import com.cloud.FleetsApps.services.VehicleTypesServices;
import com.cloud.FleetsApps.models.State;

@Controller
public class VehicleTypeController {
	
	@Autowired
	private VehicleTypesServices VehicleTypeservies;
	
	@GetMapping("/vehicle_types")
	public String GetCountries(Model model)
	{
		
		
		List<VehicleType> VehicleTypeList=VehicleTypeservies.getVehicleTypes();
		model.addAttribute("VehicleTypes",VehicleTypeList);
		
	
		return "vehicleType";
	}
	
    @PostMapping("/vehicle_types/addNew")
    public String addNew(VehicleType VehicleType) 
    {
    	VehicleTypeservies.save(VehicleType);
		return "redirect:/vehicle_types";
    }
    
    
 // fetch the id on edit page
    @RequestMapping("/vehicle_types/findById")
    @ResponseBody
	    public Optional<VehicleType>  findById(int id) {
	        return VehicleTypeservies.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/vehicle_types/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(VehicleType locataion) { 
    	VehicleTypeservies.save(locataion);	
    	 return "redirect:/vehicle_types";
    }

	
	 @RequestMapping(value="/vehicle_types/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 VehicleTypeservies.delete(id);
		 return "redirect:/vehicle_types";
	 }


}
