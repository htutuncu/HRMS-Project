package com.hrms.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.project.business.abstracts.JobAdvertisementService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.JobAdvertisement;
import com.hrms.project.entities.concretes.dtos.JobAdvertisementForAddDto;

@RestController
@RequestMapping("/api/jobAdvertisements")
public class JobAdvertisementsController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getActiveJobs")
	public DataResult<List<JobAdvertisement>> getJobsIsActive(){
		return this.jobAdvertisementService.getJobsIsActive();
	}
	
	@GetMapping("/getActiveJobsOrdered")
	public DataResult<List<JobAdvertisement>> getActiveJobsOrdered(){
		return this.jobAdvertisementService.findByIsActiveTrueOrderCreationDate();
	}
	
	@GetMapping("/getActiveJobsByEmployer")
	public DataResult<List<JobAdvertisement>> getActiveJobsByEmployer(@RequestParam String companyName){
		return this.jobAdvertisementService.findByEmployer_EmployerName(companyName);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisementForAddDto jobAdvertisement){
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.update(jobAdvertisement);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.delete(jobAdvertisement);
	}
	
}
