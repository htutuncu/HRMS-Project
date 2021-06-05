package com.hrms.project.api.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.project.business.abstracts.CvService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.cv.Cv;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {
	private CvService cvService;
	
	@Autowired
	public CvsController(CvService cvService) {
		this.cvService = cvService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Cv>> getAll(){
		return this.cvService.getAll();
	}
	
	@PostMapping("/getCvByNationalIdentity")
	public DataResult<Cv> getCvByNationalIdentity(@RequestParam String  nationalIdentity){
		return this.cvService.getCvByNationalIdentity(nationalIdentity);
	}
	
	@PostMapping("/addcvphoto")
	public Result uploadCvPhoto(String nationalIdentity, MultipartFile multipartFile) throws IOException{
		return this.cvService.imageUpload(nationalIdentity, multipartFile);
	}
}
