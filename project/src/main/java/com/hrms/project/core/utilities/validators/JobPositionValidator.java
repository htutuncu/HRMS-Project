package com.hrms.project.core.utilities.validators;

import com.hrms.project.business.constants.Messages;
import com.hrms.project.core.utilities.results.ErrorResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.JobPositionDao;
import com.hrms.project.entities.concretes.JobPosition;

public class JobPositionValidator {
	private JobPosition jobPosition;
	private JobPositionDao jobPositionDao;
	
	public JobPositionValidator(JobPosition jobPosition, JobPositionDao jobPositionDao) {
		super();
		this.jobPosition = jobPosition;
		this.jobPositionDao = jobPositionDao;
	}
	
	public Result isValid() {
		
		if(this.jobPositionDao.existsByJobName(jobPosition.getJobName()))
			return new ErrorResult(Messages.JOB_POSITION_ERROR_ALREADY_EXISTS);
		
		return new SuccessResult();
	}
	
}
