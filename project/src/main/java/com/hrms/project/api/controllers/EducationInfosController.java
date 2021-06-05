package com.hrms.project.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.project.business.abstracts.EducationInfoService;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.cv.EducationInfo;

@RestController
@RequestMapping("/api/educationInfos")
public class EducationInfosController {
	
	private EducationInfoService educationInfoService;

	@Autowired
	public EducationInfosController(EducationInfoService educationInfoService) {
		super();
		this.educationInfoService = educationInfoService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationInfo educationInfo) {
		return this.educationInfoService.add(educationInfo);
	}
	
}
