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
@Table(name="systempersonnels")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="id")
@EqualsAndHashCode(callSuper = true)
public class SystemPersonnel extends User{
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
}
