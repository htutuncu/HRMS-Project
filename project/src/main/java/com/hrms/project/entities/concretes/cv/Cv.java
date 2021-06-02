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
@Table(name = "cvs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "educationInfos","workExperiences","technologies"})
public class Cv {
	
	@Id
	@Column(name = "cv_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cvId;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Column(name = "photo_link")
	private String photoLink;
	
	@OneToMany(mappedBy = "cv")
	private List<EducationInfo> educationInfos;
	
	@OneToMany(mappedBy = "cv")
	private List<WorkExperience> workExperiences;
	
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "cv")
	private List<Technology> technologies;
}
