package com.hrms.project.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = true)
public class Employer extends User {
	
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="website")
	private String website;
}
