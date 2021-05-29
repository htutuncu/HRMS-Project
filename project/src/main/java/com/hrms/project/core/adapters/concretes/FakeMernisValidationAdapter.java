package com.hrms.project.core.adapters.concretes;

import org.springframework.stereotype.Component;

import com.hrms.project.core.adapters.abstracts.MernisValidationService;
import com.hrms.project.entities.concretes.JobSeeker;

@Component
public class FakeMernisValidationAdapter implements MernisValidationService {

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		
		return true;
	}

}
