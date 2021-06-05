package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.project.entities.concretes.cv.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer>{

}
