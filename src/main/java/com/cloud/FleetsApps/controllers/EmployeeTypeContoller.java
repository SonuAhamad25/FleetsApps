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

import com.cloud.FleetsApps.models.EmployeeType;
import com.cloud.FleetsApps.services.EmployeeTypesServices;

@Controller
public class EmployeeTypeContoller {
	
	@Autowired
	private EmployeeTypesServices EmployeeTypeservies;
	
	@GetMapping("/employee_jobs")
	public String GetCountries(Model model)
	{
		
		
		List<EmployeeType> EmployeeTypeList=EmployeeTypeservies.getEmployeeTypess();
		model.addAttribute("EmployeeTypes",EmployeeTypeList);
		
	
		return "employeeType";
	}
	
    @PostMapping("/employee_jobs/addNew")
    public String addNew(EmployeeType EmployeeType) 
    {
    	EmployeeTypeservies.save(EmployeeType);
		return "redirect:/employee_jobs";
    }
    
    
 // fetch the id on edit page
    @RequestMapping("/employee_jobs/findById")
    @ResponseBody
	    public Optional<EmployeeType>  findById(int id) {
	        return EmployeeTypeservies.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/employee_jobs/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(EmployeeType locataion) { 
    	EmployeeTypeservies.save(locataion);	
    	 return "redirect:/employee_jobs";
    }

	
	 @RequestMapping(value="/employee_jobs/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 EmployeeTypeservies.delete(id);
		 return "redirect:/employee_jobs";
	 }


}
