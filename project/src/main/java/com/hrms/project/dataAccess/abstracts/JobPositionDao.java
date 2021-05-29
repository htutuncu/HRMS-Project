package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.project.entities.concretes.JobPosition;


@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
	boolean existsByJobName(String jobName);
	JobPosition findById(int id);
}
