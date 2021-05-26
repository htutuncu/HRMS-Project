package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrms.project.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	boolean existsByMail(String mail);
}
