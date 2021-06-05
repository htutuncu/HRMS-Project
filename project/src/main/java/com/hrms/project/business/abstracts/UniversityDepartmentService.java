package com.hrms.project.business.abstracts;

import java.util.List;

import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.cv.UniversityDepartment;

public interface UniversityDepartmentService {
	Result add(UniversityDepartment universityDepartment);
	DataResult<List<UniversityDepartment>> getAll();
}
