package com.hrms.project.core.utilities.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hrms.project.business.constants.Messages;
import com.hrms.project.core.utilities.results.ErrorResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.EmployerDao;
import com.hrms.project.entities.concretes.Employer;

public class EmployerValidator {
	private Employer employer;
	private EmployerDao employerDao;
	
	public EmployerValidator(Employer employer, EmployerDao employerDao) {
		super();
		this.employer = employer;
		this.employerDao = employerDao;
	}
	
	public Result isValid() {
		String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        Pattern pattern = Pattern.compile(regex);
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
        
        return new SuccessResult();
	}
	
}
