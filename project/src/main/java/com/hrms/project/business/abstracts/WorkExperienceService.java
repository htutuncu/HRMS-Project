package com.hrms.project.business.abstracts;

import java.util.List;

import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.cv.WorkExperience;

public interface WorkExperienceService {
	Result add(WorkExperience workExperience);
	DataResult<List<WorkExperience>> getAll();
}
