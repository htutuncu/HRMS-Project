package com.hrms.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.project.business.abstracts.JobPositionService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return this.jobPositionService.getAll();
	}
	
	@PostMapping("/findbypositionis")
	public DataResult<List<JobPosition>> findByJobNameIs(@RequestBody String jobName){
		return this.jobPositionService.findByJobNameIs(jobName.trim());
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		return this.jobPositionService.add(jobPosition);
	}
}
