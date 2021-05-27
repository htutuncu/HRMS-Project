package com.hrms.project.core.utilities.validators;

import com.hrms.project.business.constants.Messages;
import com.hrms.project.core.adapters.abstracts.MernisValidationService;
import com.hrms.project.core.utilities.results.ErrorResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.JobSeekerDao;
import com.hrms.project.entities.concretes.JobSeeker;

public class JobSeekerValidator {
	private JobSeeker jobSeeker;
	private JobSeekerDao jobSeekerDao;
	private MernisValidationService mernisValidationService;
	
	public JobSeekerValidator(JobSeeker jobSeeker, JobSeekerDao jobSeekerDao, MernisValidationService mernisValidationService) {
		super();
		this.jobSeeker = jobSeeker;
		this.jobSeekerDao = jobSeekerDao;
		this.mernisValidationService = mernisValidationService;
	}
	
	public Result isValid() {
		if (jobSeeker.getFirstName().isEmpty())
            return new ErrorResult(Messages.JOB_SEEKER_ERROR_NAME_IS_BLANK);
		if (jobSeeker.getLastName().isEmpty())
            return new ErrorResult(Messages.JOB_SEEKER_ERROR_SURNAME_IS_BLANK);
		if (jobSeeker.getMail().isEmpty())
            return new ErrorResult(Messages.USER_ERROR_EMAIL_IS_BLANK);
		if (jobSeeker.getPassword().isEmpty())
            return new ErrorResult(Messages.USER_ERROR_PASSWORD_IS_BLANK);
		if (jobSeeker.getNationalIdentity().isEmpty())
            return new ErrorResult(Messages.JOB_SEEKER_ERROR_IDENTITY_NUMBER_IS_BLANK);
		if (this.jobSeekerDao.existsByMail(jobSeeker.getMail()))
            return new ErrorResult(Messages.USER_ERROR_EMAIL_ALREADY_EXISTS);
		if (this.jobSeekerDao.existsByNationalIdentity(jobSeeker.getNationalIdentity()))
            return new ErrorResult(Messages.JOB_SEEKER_ERROR_IDENTITY_NUMBER_ALREADY_EXISTS);
		
		
		if(!mernisValidationService.checkIfRealPerson(jobSeeker))
			return new ErrorResult(Messages.JOB_SEEKER_NOT_VALID_PERSON);
		
		return new SuccessResult();
	}
	
	
}
