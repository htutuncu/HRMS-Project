package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.WorkExperienceService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.WorkExperienceDao;
import com.hrms.project.entities.concretes.cv.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService{
	
	private WorkExperienceDao workExperienceDao;
	
	
	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public Result add(WorkExperience workExperience) {
		workExperienceDao.save(workExperience);
		return new SuccessResult("Work experience added.");
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(workExperienceDao.findAll());
	}

}
