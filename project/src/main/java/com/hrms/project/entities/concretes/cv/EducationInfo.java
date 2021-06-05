package com.hrms.project.entities.concretes.cv;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="educationinfos")
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_info_id")
	private int educationInfoId;
	
	@Column(name = "start_date",nullable = true)
	private LocalDate startDate;
	
	@Column(name = "end_date", nullable = true)
	private LocalDate endDate;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
	
	@ManyToOne
	@JoinColumn(name = "university_id")
	private University university;
	
	@ManyToOne
	@JoinColumn(name = "university_department_id")
	private UniversityDepartment universityDepartment;
}
