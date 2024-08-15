package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bindings.CitizenAppRegistrationInput;
import com.nt.service.ICitizenAppRegistrationService;

@RestController
@RequestMapping("Citizen_AR/Api")
public class CitizenApplicationRegistrationController {
	@Autowired
	private ICitizenAppRegistrationService service;
	@PostMapping("/save")
	public ResponseEntity<String> saveCitizenApplication(@RequestBody CitizenAppRegistrationInput inputs){
		try {
			int appId=service.registerCitizenApplication(inputs);
			if(appId>0) {
				return new ResponseEntity<String>("Citizen Application is Registered with id :: "+appId,HttpStatus.CREATED);
				
			}else
				return new ResponseEntity<String>("Invalid SSn or Citizen must belong to California state!!",HttpStatus.OK);
		}catch(Exception e) {
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST); 
		}
	}

}
