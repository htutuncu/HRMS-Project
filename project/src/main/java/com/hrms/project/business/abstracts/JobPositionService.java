package com.hrms.project.business.abstracts;

import java.util.List;

import com.hrms.project.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
