package com.hrms.project.business.abstracts;

import java.util.List;

import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.cv.University;

public interface UniversityService {
	Result add(University university);
	DataResult<List<University>> getAll();
}
