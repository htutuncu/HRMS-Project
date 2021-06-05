package com.hrms.project.entities.concretes.cv;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.project.entities.concretes.JobSeeker;

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
	
	@ManyToOne
	@JoinColumn(name = "id")
	private JobSeeker jobSeeker;
	
	@Column(name = "github_link")
	private String githubLink;
	
	@Column(name = "linkedin_link")
	private String linkedinLink;
	
	@Column(name = "cover_letter")
	private String coverLetter;
	
	@Column(name = "photo_link")
	private String photoLink;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<EducationInfo> educationInfos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<WorkExperience> workExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<Technology> technologies;
}
