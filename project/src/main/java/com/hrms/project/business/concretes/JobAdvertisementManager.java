package com.hrms.project.business.concretes;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hrms.project.business.abstracts.CityService;
import com.hrms.project.business.abstracts.EmployerService;
import com.hrms.project.business.abstracts.JobAdvertisementService;
import com.hrms.project.business.abstracts.JobPositionService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.JobAdvertisementDao;
import com.hrms.project.entities.concretes.JobAdvertisement;
import com.hrms.project.entities.concretes.dtos.JobAdvertisementForAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
	
	private JobAdvertisementDao jobAdvertisementDao;
	private CityService cityService;
	private JobPositionService jobPositionService;
	private EmployerService employerService;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,
			CityService cityService,
			JobPositionService jobPositionService,
			EmployerService employerService) {
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.cityService = cityService;
		this.jobPositionService = jobPositionService;
		this.employerService = employerService;
	}
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findAll(),"Job advertisements listed.");
	}


	@Override
	public Result add(JobAdvertisementForAddDto jobAdvertisement) {
		JobAdvertisement newJobAdvertisement = new JobAdvertisement(
				jobAdvertisement.getJobDescription(),
				jobAdvertisement.getMinSalary(),
				jobAdvertisement.getMaxSalary(),
				jobAdvertisement.getOpenPositionCount(),
				jobAdvertisement.getLastDate(),
				new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				jobAdvertisement.isActive()
				);
		newJobAdvertisement.setCity(cityService.getById(jobAdvertisement.getCityId()).getData());
		newJobAdvertisement.setJobPosition(jobPositionService.getById(jobAdvertisement.getJobPositionId()).getData());
		newJobAdvertisement.setEmployer(employerService.getByCompanyName(jobAdvertisement.getCompanyName()).getData());
		this.jobAdvertisementDao.save(newJobAdvertisement);
		return new SuccessResult("Job advertisement added.");
	}


	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement updated.");
	}


	@Override
	public Result delete(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.delete(jobAdvertisement);
		return new SuccessResult("Job advertisement deleted.");
	}


	@Override
	public DataResult<List<JobAdvertisement>> getJobsIsActive() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getJobsIsActive()
				);
	}


	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderCreationDate() {
		
		return new SuccessDataResult<List<JobAdvertisement>>
		(this.jobAdvertisementDao.findByIsActiveTrueOrderByCreationDate());
	}


	@Override
	public DataResult<List<JobAdvertisement>> findByEmployer_EmployerName(String employerName) {
		return new SuccessDataResult<List<JobAdvertisement>>
		(jobAdvertisementDao.findByIsActiveTrueAndEmployer_CompanyName(employerName));
		
	}

}
