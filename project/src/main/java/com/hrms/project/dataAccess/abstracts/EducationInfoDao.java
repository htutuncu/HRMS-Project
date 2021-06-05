package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.project.entities.concretes.cv.EducationInfo;

public interface EducationInfoDao extends JpaRepository<EducationInfo, Integer>{

}
