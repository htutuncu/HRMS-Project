package com.hrms.project.business.abstracts;

import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.cv.EducationInfo;

public interface EducationInfoService {
	Result add(EducationInfo educationInfo);
}
