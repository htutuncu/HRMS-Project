package com.hrms.project.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.project.entities.concretes.cv.Cv;

public interface CvDao extends JpaRepository<Cv, Integer>{
	
	@Query("From Cv c where c.jobSeeker.nationalIdentity=?1")
	Cv getCvByNationalIdentity(String nationalIdentity);
}
	
