package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/ssa/web-api")
public class SSACheckOperationController {
	@GetMapping("/find/{ssnNo}")
	public ResponseEntity<String> getStateBySSNNo(@PathVariable Integer ssnNo ){
		if(String.valueOf(ssnNo).length()!=9) {
			return new ResponseEntity<String>("invalid ssn No",HttpStatus.BAD_REQUEST);
		}
		int stateCode=ssnNo%100;
		String stateName=null;
		if(stateCode==01) {
			stateName="Washington DC";
		}
		else if(stateCode==02) {
			stateName="Ohio";
		}
		else if(stateCode==03) {
			stateName="Texas";
		}
		else if(stateCode==04) {
			stateName="California";
		}
		else if(stateCode==05) {
			stateName="florida";
		}
		else {
			stateName="invalid ssn";
		}
		return new ResponseEntity<String>(stateName,HttpStatus.OK);
	}

}
