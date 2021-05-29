package com.hrms.project.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.project.business.abstracts.CityService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	private CityService cityService;
	
	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}
	
	@GetMapping("getById")
	public DataResult<City> getById(@RequestParam int id){
		return cityService.getById(id);
	}
}
