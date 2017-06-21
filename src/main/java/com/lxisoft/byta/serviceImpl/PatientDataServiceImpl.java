package com.lxisoft.byta.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.lxisoft.byta.model.PatientHistory;
import com.lxisoft.byta.repository.PatientDataRepo;
import com.lxisoft.byta.service.PatientDataService;

/**
 * It is an implementation class which is used to control the request and response.
 * 
 * 
 * @author ARUN JOHNSON
 * @version 1.0.0
 * @see com.lxisoft.byta.repository.PatientDataRepo
 * @see com.lxisoft.byta.model.PatientHistory
 * @see com.lxisoft.byta.service.PatientDataService
 */

@Service
@PreAuthorize("hasRole('ROLE_USER')")

public class PatientDataServiceImpl implements PatientDataService {
	@Autowired
	private PatientDataRepo repo;
	
	
	/**
	 * This is a method which is used to save a {@link PatientHistory} data  using {@link com.lxisoft.byta.repository.PatientDataRepo#save(PatientHistory)}
	 * @param patient
	 * @return com.lxisoft.byta.model.PatientHistory
	 */
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	public PatientHistory save(PatientHistory patient) {
		return repo.save(patient);
	}

	
	/**
	 * This is a method which is used to find a {@link PatientHistory} data based on Id using {@link com.lxisoft.byta.repository.PatientDataRepo#findById(long)}
	 * 
	 * @param id
	 * @return com.lxisoft.byta.model.PatientHistory
	 */
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	public PatientHistory findById(long id) {
		return repo.findById(id);
	}

}
