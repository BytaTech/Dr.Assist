package com.lxisoft.byta.service;


import com.lxisoft.byta.model.PatientHistory;

/**
 * It is an interface which is used as a service layer
 * 
 * 
 * @author ARUN JOHNSON
 * @version 1.0.0
 */
public interface PatientDataService  {
	public PatientHistory save(PatientHistory patient) ;
	public PatientHistory findById(long id);
	

}
