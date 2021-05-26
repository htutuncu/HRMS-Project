package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.EmployerService;
import com.hrms.project.business.constants.Messages;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.ErrorResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.EmployerDao;
import com.hrms.project.entities.concretes.Employer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>
		(this.employerDao.findAll(),"Employers listed.");
	}
	
	

	@Override
	public Result add(Employer employer) {
		Pattern pattern= Pattern.compile("@" + employer.getWebsite());
        Matcher matcher = pattern.matcher(employer.getMail());
		
		
		if (employer.getCompanyName().isEmpty())
            return new ErrorResult(Messages.EMPLOYER_ERROR_COMPANY_NAME_IS_BLANK);
        if (employer.getWebsite().isEmpty())
            return new ErrorResult(Messages.EMPLOYER_ERROR_WEBSITE_IS_BLANK);
        if (employer.getPhone().isEmpty())
            return new ErrorResult(Messages.EMPLOYER_ERROR_TELEPHONE_IS_BLANK);
        if (employer.getMail().isEmpty())
            return new ErrorResult(Messages.USER_ERROR_EMAIL_IS_BLANK);
        if (employer.getPassword().isEmpty())
            return new ErrorResult(Messages.USER_ERROR_PASSWORD_IS_BLANK);
        if (!matcher.matches())
            return new ErrorResult(Messages.USER_ERROR_EMAIL_IS_NOT_VALID);
        if (this.employerDao.existsByMail(employer.getMail()))
            return new ErrorResult(Messages.USER_ERROR_EMAIL_ALREADY_EXISTS);
		
		this.employerDao.save(employer);
		return new SuccessResult(Messages.EMPLOYER_SUCCESS_ADDED);
	}
}
