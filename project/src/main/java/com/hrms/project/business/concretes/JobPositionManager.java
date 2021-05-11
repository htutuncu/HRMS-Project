package com.hrms.project.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.project.business.abstracts.JobPositionService;
import com.hrms.project.dataAccess.abstracts.JobPositionDao;
import com.hrms.project.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao jobPositionDao;
	
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}



	@Override
	public List<JobPosition> getAll() {
		
		return this.jobPositionDao.findAll();
	}

}
