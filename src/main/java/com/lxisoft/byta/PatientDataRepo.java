package com.lxisoft.byta;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * It is a interface to create a repository which extends {@link JpaRepository}
 * 
 * @author ARUN JOHNSON
 *@version 1.0.0
 *@see JpaRepository
 */

public interface PatientDataRepo extends JpaRepository<PatientHistory, String> {

	/**
	 * This is a method which is used to find a {@link PatientHistory} data based on Id
	 * 
	 * @param id
	 * @return {@link PatientHistory}
	 */
	public PatientHistory findById(long id);
	
}
