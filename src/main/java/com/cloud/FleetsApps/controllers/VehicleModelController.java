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

import com.cloud.FleetsApps.models.VehicleModel;
import com.cloud.FleetsApps.services.VehicleModelsServices;


@Controller
public class VehicleModelController {
	@Autowired
	private VehicleModelsServices VehicleModelservies;
	
	@GetMapping("/vehicle_models")
	public String GetCountries(Model model)
	{
		
		
		List<VehicleModel> VehicleModelList=VehicleModelservies.getVehicleModels();
		model.addAttribute("VehicleModels",VehicleModelList);
		
	
		return "vehicleModel";
	}
	
    @PostMapping("/vehicle_models/addNew")
    public String addNew(VehicleModel VehicleModel) 
    {
    	VehicleModelservies.save(VehicleModel);
		return "redirect:/vehicle_models";
    }
    
    
 // fetch the id on edit page
    @RequestMapping("/vehicle_models/findById")
    @ResponseBody
	    public Optional<VehicleModel>  findById(int id) {
	        return VehicleModelservies.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/vehicle_models/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(VehicleModel locataion) { 
    	VehicleModelservies.save(locataion);	
    	 return "redirect:/vehicle_models";
    }

	
	 @RequestMapping(value="/vehicle_models/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 VehicleModelservies.delete(id);
		 return "redirect:/vehicle_models";
	 }


}
