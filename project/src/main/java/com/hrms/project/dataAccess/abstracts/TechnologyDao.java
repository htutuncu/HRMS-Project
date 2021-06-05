package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.project.entities.concretes.cv.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer>{

}
