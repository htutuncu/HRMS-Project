package com.hrms.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.project.business.abstracts.UniversityService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.cv.University;

@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {
	private UniversityService universityService;

	@Autowired
	public UniversitiesController(UniversityService universityService) {
		super();
		this.universityService = universityService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody University university) {
		return this.universityService.add(university);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<University>> getAll(){
		return this.universityService.getAll();
	}
}
