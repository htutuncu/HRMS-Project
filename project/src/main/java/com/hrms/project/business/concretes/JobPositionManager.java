package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.JobPositionService;
import com.hrms.project.business.constants.Messages;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.JobPositionDao;
import com.hrms.project.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	
	
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
	public DataResult<List<JobPosition>> findByJobNameIs(String jobName) {
		return new SuccessDataResult<>(this.jobPositionDao.findByJobNameIs(jobName));
	}



	@Override
	public Result add(JobPosition jobPosition) {
		this.jobPositionDao.save(jobPosition);
		return new SuccessResult(Messages.JOB_POSITION_SUCCESS_ADDED);
	}

}
