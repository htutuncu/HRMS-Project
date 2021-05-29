package com.hrms.project.entities.concretes.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementForAddDto {
	private String jobDescription;
	private int minSalary;
	private int maxSalary;
	private int openPositionCount;
	private LocalDate lastDate;
	private boolean isActive;
	private int cityId;
	private int jobPositionId;
	private String companyName;
}
