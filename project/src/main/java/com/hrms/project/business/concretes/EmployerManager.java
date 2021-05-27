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
import com.hrms.project.core.utilities.validators.EmployerValidator;
import com.hrms.project.dataAccess.abstracts.EmployerDao;
import com.hrms.project.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmployerValidator employerValidator;
	
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
		this.employerValidator = new EmployerValidator(employer, employerDao);
		Result result = employerValidator.isValid();
		if( result instanceof ErrorResult)
			return result;
	
		
		this.employerDao.save(employer);
		return new SuccessResult(Messages.EMPLOYER_SUCCESS_ADDED);
	}
}
