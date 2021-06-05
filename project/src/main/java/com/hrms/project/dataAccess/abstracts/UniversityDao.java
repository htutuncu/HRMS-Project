package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.project.entities.concretes.cv.University;

public interface UniversityDao extends JpaRepository<University, Integer> {

}
