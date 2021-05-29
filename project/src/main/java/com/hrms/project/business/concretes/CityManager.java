package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.CityService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.dataAccess.abstracts.CityDao;
import com.hrms.project.entities.concretes.City;



@Service
public class CityManager implements CityService{
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

	@Override
	public DataResult<City> getById(int id) {
		
		return new SuccessDataResult<City>
		(this.cityDao.findById(id),"City getted.");
	}
}
