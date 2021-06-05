package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.project.entities.concretes.cv.UniversityDepartment;

public interface UniversityDepartmentDao extends JpaRepository<UniversityDepartment, Integer>{

}
