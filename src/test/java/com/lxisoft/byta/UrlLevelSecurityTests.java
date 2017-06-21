/*
 * Copyright 2014 the original author or authors.
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;


/**
 * Test cases that verify the URL level of security by using the Spring MVC test framework.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlLevelSecurityTests {

	static final String PAYLOAD = "{\"pulse\": \"72\", \"weight\": \"51\", " + "}";

	@Autowired WebApplicationContext context;
	@Autowired FilterChainProxy filterChain;

	MockMvc mvc;

	@Before
	public void setUp() {

		this.mvc = webAppContextSetup(context).addFilters(filterChain).build();

		SecurityContextHolder.clearContext();
	}

	@Test
	public void allowsAccessToRootResource() throws Exception {

		mvc.perform(get("/").//
				accept(MediaTypes.HAL_JSON)).//
				andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON)).//
				andExpect(status().isOk()).//
				andDo(print());
	}

	@Test
	public void rejectsPostAccessToCollectionResource() throws Exception {

		mvc.perform(post("/medicalhistory").//
				content(PAYLOAD).//
				accept(MediaTypes.HAL_JSON)).//
				andExpect(status().isUnauthorized()).//
				andDo(print());
	}

	@Test
	public void allowsGetRequestsButRejectsPostForUser() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.ACCEPT, MediaTypes.HAL_JSON_VALUE);
		headers.add(HttpHeaders.AUTHORIZATION, "Basic " + new String(Base64.encode(("greg:turnquist").getBytes())));

		mvc.perform(get("/medicalhistory").//
				headers(headers)).//
				andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON)).//
				andExpect(status().isOk()).//
				andDo(print());

		mvc.perform(post("/medicalhistory").//
				headers(headers)).//
				andExpect(status().isForbidden()).//
				andDo(print());
	}

	@Test
	public void allowsPostRequestForDoctor() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaTypes.HAL_JSON_VALUE);
		headers.set(HttpHeaders.AUTHORIZATION, "Basic " + new String(Base64.encode(("arun:arun").getBytes())));

		mvc.perform(get("/medicalhistory").//
				headers(headers)).//
				andExpect(content().contentTypeCompatibleWith(MediaTypes.HAL_JSON)).//
				andExpect(status().isOk()).//
				andDo(print());

		headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);


	}
}
