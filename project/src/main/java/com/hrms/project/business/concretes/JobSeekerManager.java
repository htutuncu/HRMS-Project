package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.JobSeekerService;
import com.hrms.project.business.constants.Messages;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.ErrorResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.JobSeekerDao;
import com.hrms.project.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>
		(this.jobSeekerDao.findAll(),"Job Seekers listed.");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
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
		
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.JOB_SEEKER_SUCCESS_ADDED);
	}

}
