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
 *@see PatientDataRepo
 *@see PatientHistory
 */
@RestController
public class MainController {
	@Autowired
	PatientDataRepo repo;

	/**
	 * This method is used to save the Patient medic data by using the repository {@link PatientDataRepo} 
	 * @param patient
	 * @return 
	 */
	@RequestMapping("/savmedicaldata")
	public PatientHistory saveData(@ModelAttribute PatientHistory patient) {

		return repo.save(patient);

	}
	
	/**
	 * This method is used to update the Patient medic data by using the repository {@link PatientDataRepo} 
	 * 
	 * @param patient
	 * @return
	 */

	@RequestMapping("/updatemedicaldata")
	public PatientHistory updateData(@ModelAttribute PatientHistory patient) {		
		
		return repo.save(patient);

	}


	/**
	 * This method is used to get the Patient medic data by using the repository {@link PatientDataRepo} 
	 * 
	 * @param patient
	 * @return
	 */
	@RequestMapping("/getmedicaldata")
	public PatientHistory getData(long id) {

		return repo.findById(id);

	}

}
