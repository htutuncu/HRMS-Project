package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.UniversityDepartmentService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.UniversityDepartmentDao;
import com.hrms.project.entities.concretes.cv.UniversityDepartment;

@Service
public class UniversityDepartmentManager implements UniversityDepartmentService {

	private UniversityDepartmentDao universityDepartmentDao;
	
	
	@Autowired
	public UniversityDepartmentManager(UniversityDepartmentDao universityDepartmentDao) {
		super();
		this.universityDepartmentDao = universityDepartmentDao;
	}

	@Override
	public Result add(UniversityDepartment universityDepartment) {
		this.universityDepartmentDao.save(universityDepartment);
		return new SuccessResult("University Department added.");
	}

	@Override
	public DataResult<List<UniversityDepartment>> getAll() {
		
		return new SuccessDataResult<List<UniversityDepartment>>(universityDepartmentDao.findAll());
	}

}
