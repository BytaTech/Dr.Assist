/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lxisoft.byta;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import com.lxisoft.byta.model.PatientHistory;
import com.lxisoft.byta.repository.PatientDataRepo;

/**
 * Collection of test cases used to verify method-level security.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MethodLevelSecurityTests {

	@Autowired PatientDataRepo patientRepository;

	@Before
	public void setUp() {
		SecurityContextHolder.clearContext();
	}

	@Test
	public void rejectsMethodInvocationsForNoAuth() {

		try {
			patientRepository.findAll();
			fail("Expected a security error");
		} catch (AuthenticationCredentialsNotFoundException e) {
			// expected
		}

		try {
			patientRepository.save(new PatientHistory());
			fail("Expected a security error");
		} catch (AuthenticationCredentialsNotFoundException e) {
			// expected
		}

		
	}

	@Test
	public void rejectsMethodInvocationsForAuthWithInsufficientPermissions() {

		SecurityUtils.runAs("system", "system", "ROLE_USER");

		patientRepository.findAll();

		try {
			patientRepository.save(new PatientHistory());
			fail("Expected a security error");
		} catch (AccessDeniedException e) {
			// expected
		}
	
	}

	@Test
	public void allowsMethodInvocationsForAuthWithSufficientPermissions() {

		SecurityUtils.runAs("system", "system", "ROLE_USER", "ROLE_DOCTOR");

		patientRepository.findAll();
		patientRepository.save(new PatientHistory());
	}
}
