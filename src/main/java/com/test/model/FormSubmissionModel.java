package com.test.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
public class FormSubmissionModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private String email;
	
	private String mobileNumber;
	
	private String message;
//	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date dateTime;
}
