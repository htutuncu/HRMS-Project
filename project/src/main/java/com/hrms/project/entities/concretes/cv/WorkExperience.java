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
@Table(name = "workexperiences")
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {
	@Id
	@Column(name = "work_experience_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workExperienceId;
	
	@Column(name = "start_date")
	private LocalDate startDate;
	
	@Column(name = "end_date",nullable = true)
	private LocalDate endDate;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "work_position")
	private String workPosition;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
}
