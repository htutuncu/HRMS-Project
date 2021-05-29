package com.hrms.project.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import com.hrms.project.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{
	City findById(int id);
}
