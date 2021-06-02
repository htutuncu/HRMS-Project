package com.hrms.project.entities.concretes;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="jobadvertisements")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="job_description",nullable=false)
	private String jobDescription;
	
	@Column(name="min_salary",nullable=true)
	private int minSalary;
	
	@Column(name="max_salary",nullable=true)
	private int maxSalary;
	
	@Column(name="open_position_count",nullable=false)
	private int openPositionCount;
	
	@Column(name="last_date",nullable=false)
	private LocalDate lastDate;
	
	@Column(name="creation_date",nullable=false)
	private LocalDate creationDate;
	
	@Column(name="is_active",nullable=false)
	private boolean isActive;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	public JobAdvertisement(String jobDescription, int minSalary, int maxSalary, int openPositionCount,
			LocalDate lastApplyDate, LocalDate createDate, boolean isActive) {
		super();
		this.jobDescription = jobDescription;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.openPositionCount = openPositionCount;
		this.lastDate = lastApplyDate;
		this.creationDate = createDate;
		this.isActive = isActive;
	}
	
	
	
}
