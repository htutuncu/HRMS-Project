package com.hrms.project.business.abstracts;

import java.util.List;

import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
	
	Result add(JobPosition jobPosition);
	Result update(JobPosition jobPosition);
	Result delete(JobPosition jobPosition);
	DataResult<JobPosition> getById(int id);
}
