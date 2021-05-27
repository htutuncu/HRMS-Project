package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.JobSeekerService;
import com.hrms.project.business.constants.Messages;
import com.hrms.project.core.adapters.abstracts.MernisValidationService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.ErrorResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.core.utilities.validators.JobSeekerValidator;
import com.hrms.project.dataAccess.abstracts.JobSeekerDao;
import com.hrms.project.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	private MernisValidationService mernisValidationService;
	private JobSeekerValidator jobSeekerValidator;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao,MernisValidationService mernisValidationService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.mernisValidationService = mernisValidationService;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>
		(this.jobSeekerDao.findAll(),Messages.JOB_SEEKER_SUCCESS_DATA_LISTED);
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerValidator = new JobSeekerValidator(jobSeeker, jobSeekerDao, mernisValidationService);
		Result result = jobSeekerValidator.isValid();
		if( result instanceof ErrorResult)
			return result;
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_SUCCESS_ADDED);
	}

}
