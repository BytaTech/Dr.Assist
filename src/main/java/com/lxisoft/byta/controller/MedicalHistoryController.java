package com.lxisoft.byta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxisoft.byta.model.PatientHistory;
import com.lxisoft.byta.serviceImpl.PatientDataServiceImpl;

/**
 * It is Controller class which is used to control the request and response.
 * 
 * 
 * @author ARUN JOHNSON
 * @version 1.0.0
 * @see com.lxisoft.byta.model.PatientHistory
 * @see com.lxisoft.byta.serviceImpl.PatientDataServiceImpl
 */
@RestController
@RequestMapping("/medicalhistory")
public class MedicalHistoryController {
	@Autowired
	private PatientDataServiceImpl service;

	/**
	 * This method is used to save the Patient medic data by using the service
	 * class
	 * {@link com.lxisoft.byta.serviceImpl.PatientDataServiceImpl#save(PatientHistory)}
	 * 
	 * @param patient
	 * @return
	 */
	@RequestMapping("/save")
	public PatientHistory saveData(@ModelAttribute PatientHistory patient) {
		return service.save(patient);

	}

	/**
	 * This method is used to update the Patient medic data by using the service
	 * class
	 * {@link com.lxisoft.byta.serviceImpl.PatientDataServiceImpl#save(PatientHistory)}
	 * 
	 * @param patient
	 * @return {@link PatientHistory}
	 */

	@RequestMapping("/update")
	public PatientHistory updateData(@ModelAttribute PatientHistory patient) {

		return service.save(patient);

	}

	/**
	 * This method is used to get the Patient medic data by using the service class
	 * {@link com.lxisoft.byta.serviceImpl.PatientDataServiceImpl#findById(long)}
	 * 
	 * @param patient
	 * @return {@link PatientHistory}
	 */
	@RequestMapping("/read")
	public PatientHistory getData(long id) {

		return service.findById(id);

	}

}
