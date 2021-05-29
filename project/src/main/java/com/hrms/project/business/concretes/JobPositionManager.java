package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.JobPositionService;
import com.hrms.project.business.constants.Messages;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.ErrorDataResult;
import com.hrms.project.core.utilities.results.ErrorResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.core.utilities.validators.JobPositionValidator;
import com.hrms.project.dataAccess.abstracts.JobPositionDao;
import com.hrms.project.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	private JobPositionValidator jobPositionValidator;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}



	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>
		(this.jobPositionDao.findAll(),Messages.JOB_POSITION_SUCCESS_DATA_LISTED);
				
				
	}
	
	



	@Override
	public Result add(JobPosition jobPosition) {
		jobPositionValidator = new JobPositionValidator(jobPosition, jobPositionDao);
		Result result = jobPositionValidator.isValid();
		if( result instanceof ErrorResult)
			return result;
		
		
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(Messages.JOB_POSITION_SUCCESS_ADDED);
	}



	@Override
	public DataResult<JobPosition> getById(int id) {
		JobPosition jobPosition = jobPositionDao.findById(id);
		if(jobPosition == null)
			return new ErrorDataResult<JobPosition>();
		return new SuccessDataResult<JobPosition>(jobPosition);
	}



	@Override
	public Result update(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job position updated.");
	}



	@Override
	public Result delete(JobPosition jobPosition) {
		this.jobPositionDao.delete(jobPosition);
		return new SuccessResult("Job position deleted.");
	}

}
