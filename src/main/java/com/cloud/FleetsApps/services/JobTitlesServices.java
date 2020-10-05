package com.cloud.FleetsApps.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.FleetsApps.models.JobTitle;
import com.cloud.FleetsApps.repositories.JobTitlesRepository;
@Service
@Transactional
public class JobTitlesServices {
	@Autowired
	public JobTitlesRepository JobTitlesRepository;
	
	//return list of country
	public List<JobTitle> getJobTitless() {
		
		return JobTitlesRepository.findAll();
	}


	//Save New Country
	public void save(JobTitle JobTitles) 
	{
		JobTitlesRepository.save(JobTitles);
		
	}
	public Optional<JobTitle> findById(int id) {

		return JobTitlesRepository.findById(id);
	}


	public void delete(int id) {
		JobTitlesRepository.deleteById(id);	
		
	}


}
