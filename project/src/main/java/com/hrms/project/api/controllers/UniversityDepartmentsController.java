package com.hrms.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.project.business.abstracts.UniversityDepartmentService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.cv.UniversityDepartment;

@RestController
@RequestMapping("/api/universitydepartments")
public class UniversityDepartmentsController {
	private UniversityDepartmentService universityDepartmentService;
	
	@Autowired
	public UniversityDepartmentsController(UniversityDepartmentService universityDepartmentService) {
		super();
		this.universityDepartmentService = universityDepartmentService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody UniversityDepartment universityDepartment) {
		return this.universityDepartmentService.add(universityDepartment);
	}
	
	@GetMapping("/getall")
	public DataResult<List<UniversityDepartment>> getAll(){
		return this.universityDepartmentService.getAll();
	}
}
