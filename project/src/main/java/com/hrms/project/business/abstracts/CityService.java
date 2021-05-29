package com.hrms.project.business.abstracts;

import java.util.List;

import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.entities.concretes.City;

public interface CityService {
	DataResult<List<City>> getAll();
	DataResult<City> getById(int id);
}
