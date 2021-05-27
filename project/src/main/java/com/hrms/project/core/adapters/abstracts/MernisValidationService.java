package com.hrms.project.core.adapters.abstracts;

import com.hrms.project.entities.concretes.JobSeeker;

public interface MernisValidationService {
	boolean checkIfRealPerson(JobSeeker jobSeeker);
}
