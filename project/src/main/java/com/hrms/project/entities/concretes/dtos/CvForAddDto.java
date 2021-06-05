package com.hrms.project.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CvForAddDto {
	private String githubLink;
	private String linkedinLink;
	private String coverLetter;
	private String photoLink;
}
