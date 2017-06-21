package com.lxisoft.byta.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import com.lxisoft.byta.model.PatientHistory;


/**
 * It is a interface to create a repository which extends {@link JpaRepository}
 * 
 * @author ARUN JOHNSON
 *@version 1.0.0
 *@see org.springframework.data.jpa.repository.JpaRepository
 *@see com.lxisoft.byta.model.PatientHistory
 */
@PreAuthorize("hasRole('ROLE_USER')")
public interface PatientDataRepo extends JpaRepository<PatientHistory, String> {

	/**
	 * This is a method used to find  data based on Id 
	 * 
	 * @param id
	 * @return {@link PatientHistory}
	 */
	@PreAuthorize("hasRole('ROLE_DOCTOR')")

	public PatientHistory findById(long id);
	
	
	@Override
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	<S extends PatientHistory> S save(S s);
	
	
}
