package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.project.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
}
