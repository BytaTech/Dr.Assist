package com.lxisoft.byta;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * PatientHistory is a class to create table in database for storing Patient
 * medical data
 * 
 * @author ARUN JOHNSON
 * @version 1.0.0
 * 
 *
 */

@Entity
public class PatientHistory {

	@Id
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPreviousConsultHistory() {
		return previousConsultHistory;
	}

	public void setPreviousConsultHistory(String previousConsultHistory) {
		this.previousConsultHistory = previousConsultHistory;
	}

	public String getDurationOfTheIllness() {
		return durationOfTheIllness;
	}

	public void setDurationOfTheIllness(String durationOfTheIllness) {
		this.durationOfTheIllness = durationOfTheIllness;
	}

	public String getIllnessStatus() {
		return illnessStatus;
	}

	public void setIllnessStatus(String illnessStatus) {
		this.illnessStatus = illnessStatus;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDurationOfSymptoms() {
		return durationOfSymptoms;
	}

	public void setDurationOfSymptoms(String durationOfSymptoms) {
		this.durationOfSymptoms = durationOfSymptoms;
	}

	public float getTemprature() {
		return temprature;
	}

	public void setTemprature(float temprature) {
		this.temprature = temprature;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public int getBloodPressure() {
		return bloodPressure;
	}

	public void setBloodPressure(int bloodPressure) {
		this.bloodPressure = bloodPressure;
	}

	public int getRespirationCount() {
		return respirationCount;
	}

	public void setRespirationCount(int respirationCount) {
		this.respirationCount = respirationCount;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public int getSugarLevel() {
		return sugarLevel;
	}

	public void setSugarLevel(int sugarLevel) {
		this.sugarLevel = sugarLevel;
	}

}
