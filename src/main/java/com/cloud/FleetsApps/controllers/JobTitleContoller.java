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


import com.cloud.FleetsApps.models.JobTitle;
import com.cloud.FleetsApps.services.JobTitlesServices;


@Controller
public class JobTitleContoller {
	@Autowired
	private JobTitlesServices JobTitleservies;
	
	@GetMapping("/job_titles")
	public String GetCountries(Model model)
	{
		
		
		List<JobTitle> JobTitleList=JobTitleservies.getJobTitless();
		model.addAttribute("JobTitles",JobTitleList);
		
	
		return "jobTitle";
	}
	
    @PostMapping("/job_titles/addNew")
    public String addNew(JobTitle JobTitle) 
    {
    	JobTitleservies.save(JobTitle);
		return "redirect:/job_titles";
    }
    
    
 // fetch the id on edit page
    @RequestMapping("/job_titles/findById")
    @ResponseBody
	    public Optional<JobTitle>  findById(int id) {
	        return JobTitleservies.findById(id);
	        
	        
	    }
    
    //this method use for  save edit data
    @RequestMapping(value="/job_titles/update", method={RequestMethod.POST,RequestMethod.PUT})
    public String update(JobTitle locataion) { 
    	JobTitleservies.save(locataion);	
    	 return "redirect:/job_titles";
    }

	
	 @RequestMapping(value="/job_titles/delete", method={RequestMethod.GET,RequestMethod.DELETE})
	 public String delete(int id)
	 {
		 JobTitleservies.delete(id);
		 return "redirect:/job_titles";
	 }


}
