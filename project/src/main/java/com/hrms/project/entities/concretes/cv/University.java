package com.hrms.project.entities.concretes.cv;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "universities")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "educationInfos"})
public class University {
	@Id
	@Column(name = "university_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int universityId;
	
	@Column(name = "university_name")
	private String universityName;
	
	@OneToMany(mappedBy = "university")
	private List<EducationInfo> educationInfos;
	
}
