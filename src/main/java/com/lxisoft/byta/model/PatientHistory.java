package com.lxisoft.byta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * PatientHistory is a class to create table in database for storing Patient
 * medical data
 * 
 * @author ARUN JOHNSON
 * @version 1.0.0
 * 
 *
 */
@Data
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
public class PatientHistory {

	@Id
	@GeneratedValue
	private long id;
	private String bloodGroup;
	private String previousConsultHistory;
	private String durationOfTheIllness;
	private String illnessStatus;
	private String symptoms;
	private String durationOfSymptoms;
	private float temprature;
	private int pulse;
	private int bloodPressure;
	private int respirationCount;
	private int weight;
	private String medicalHistory;
	private int sugarLevel;
	

	
}
