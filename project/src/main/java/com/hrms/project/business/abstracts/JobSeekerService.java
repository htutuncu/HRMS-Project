package com.hrms.project.business.abstracts;

import java.util.List;

import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.JobSeeker;


public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
}
