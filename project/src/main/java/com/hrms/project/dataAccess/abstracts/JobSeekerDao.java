package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.project.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	boolean existsByMail(String mail);
	boolean existsByNationalIdentity(String nationalIdentity);
	JobSeeker findByNationalIdentity(String nationalIdentity);
}
