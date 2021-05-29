package com.hrms.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.project.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{
	@Query("From JobAdvertisement where isActive=true")
	List<JobAdvertisement> getJobsIsActive();
	List<JobAdvertisement> findByIsActiveTrueOrderByCreationDate();
	List<JobAdvertisement> findByIsActiveTrueAndEmployer_CompanyName(String companyName);
}
