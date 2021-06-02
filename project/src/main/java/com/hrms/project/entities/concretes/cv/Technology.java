package com.hrms.project.entities.concretes.cv;

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
@Table(name = "technologies")
@AllArgsConstructor
@NoArgsConstructor
public class Technology {
	
	@Id
	@Column(name = "technology_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int technologyId;
	
	@Column(name = "tech_name")
	private String techName;
	
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;
}
