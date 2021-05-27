package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.project.entities.concretes.SystemPersonnel;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel, Integer> {
	
	
}
