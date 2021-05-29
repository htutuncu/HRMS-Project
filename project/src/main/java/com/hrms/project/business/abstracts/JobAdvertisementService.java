package com.hrms.project.business.abstracts;

import java.util.List;

import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.JobAdvertisement;
import com.hrms.project.entities.concretes.dtos.JobAdvertisementForAddDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisementForAddDto jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(JobAdvertisement jobAdvertisement);
	
	DataResult<List<JobAdvertisement>> getJobsIsActive();
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderCreationDate();
	DataResult<List<JobAdvertisement>> findByEmployer_EmployerName(String employerName);
}
