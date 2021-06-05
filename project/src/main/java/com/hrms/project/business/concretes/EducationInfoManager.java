package com.hrms.project.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.EducationInfoService;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.EducationInfoDao;
import com.hrms.project.entities.concretes.cv.EducationInfo;

@Service
public class EducationInfoManager implements EducationInfoService {
	
	private EducationInfoDao educationInfoDao;
	
	
	@Autowired
	public EducationInfoManager(EducationInfoDao educationInfoDao) {
		super();
		this.educationInfoDao = educationInfoDao;
	}



	@Override
	public Result add(EducationInfo educationInfo) {
		this.educationInfoDao.save(educationInfo);
		return new SuccessResult("Education Information added.");
	}

}
