package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller class to meet requests and responses from browser
 * 
 * @author ARUN JOHNSON
 * @version 1.0.0
 * @see TestStub
 * 
 *
 */
@RestController
public class MainController {

	@RequestMapping("/showpatientdetails")
	public TestStub showDetails() {

		return new TestStub();
	}

}
