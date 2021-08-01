package com.yin4learn.jsonbindtouse.controller;

import java.io.File;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yin4learn.jsonbindtouse.model.Address;
import com.yin4learn.jsonbindtouse.model.Student;

@RestController
@RequestMapping("/api")
public class Controller {
	

	@GetMapping("/jsoninput")
	public String checkingApp() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File resource = new ClassPathResource("data/sample-full.json").getFile();
			// String text = new String(Files.readAllBytes(resource.toPath()));
			
			Student theStudent = mapper.readValue(resource, Student.class);
			
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			
			// print out address: street and city
			Address tempAddress = theStudent.getAddress();	
			System.out.println("Street = " + tempAddress.getStreet());
			System.out.println("City = " + tempAddress.getCity());
						
			for (String tempLang : theStudent.getLanguages()) {
				System.out.println(tempLang);
			}

		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		return "Application is running as expected!";
	}
}
