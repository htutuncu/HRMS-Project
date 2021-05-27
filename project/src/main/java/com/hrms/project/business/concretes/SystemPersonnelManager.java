package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.SystemPersonnelService;
import com.hrms.project.business.constants.Messages;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.SystemPersonnelDao;
import com.hrms.project.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService{
	
	private SystemPersonnelDao systemPersonnelDao;
	
	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
	}
	
	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>>
		(this.systemPersonnelDao.findAll(),Messages.SYSTEM_PERSONNEL_SUCCESS_DATA_LISTED);
	}

	@Override
	public Result add(SystemPersonnel systemPersonnel) {
		this.systemPersonnelDao.save(systemPersonnel);
		return new SuccessResult(Messages.SYSTEM_PERSONNEL_SUCCESS_ADDED);
	}

}
