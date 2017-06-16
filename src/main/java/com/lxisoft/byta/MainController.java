package com.lxisoft.byta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * It is Controller class which is used to control the request and response.
 * 
 * 
 * @author ARUN JOHNSON
 * @version 1.0.0
 * @see PatientHistory
 * @see PatientDataServiceImpl
 */
@RestController
@RequestMapping("/medicalhistory")
public class MainController {
	@Autowired
	PatientDataServiceImpl repo;

	/**
	 * This method is used to save the Patient medic data by using the service
	 * class {@link PatientDataServiceImpl}
	 * 
	 * @param patient
	 * @return
	 */
	@RequestMapping("/save")
	public PatientHistory saveData(@ModelAttribute PatientHistory patient) {

		return repo.save(patient);

	}

	/**
	 * This method is used to update the Patient medic data by using the service
	 * class {@link PatientDataServiceImpl}
	 * 
	 * @param patient
	 * @return
	 */

	@RequestMapping("/update")
	public PatientHistory updateData(@ModelAttribute PatientHistory patient) {

		return repo.save(patient);

	}

	/**
	 * This method is used to get the Patient medic data by using the service
	 * class {@link PatientDataServiceImpl}
	 * 
	 * @param patient
	 * @return
	 */
	@RequestMapping("/read")
	public PatientHistory getData(long id) {

		return repo.findById(id);

	}

}
