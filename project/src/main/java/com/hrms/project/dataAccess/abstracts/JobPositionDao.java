package com.hrms.project.dataAccess.abstracts;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrms.project.entities.concretes.JobPosition;


@Repository
public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	List<JobPosition> findByJobNameIs(String jobName);
	boolean existsByJobName(String jobName);
}
