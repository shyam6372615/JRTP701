package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nt.bindings.CitizenAppRegistrationInput;
import com.nt.entity.CitizenRegistrationEntity;
import com.nt.repository.IApplicationRegistrationRepository;

@Service

public class CitizenAppRegistrationServiceImpl implements ICitizenAppRegistrationService {
	@Autowired
	private IApplicationRegistrationRepository IApplicationRegistrationRepo;
	@Autowired
	private RestTemplate template;
	@Value("${ar.ssa-web.url}")
	private String endPointUrl;
	@Value("${ar.state}")
	private String targetState;
	

	@Override
	public Integer registerCitizenApplication(CitizenAppRegistrationInput Inputs) {
		
		ResponseEntity<String> response=template.exchange(endPointUrl, HttpMethod.GET,null,String.class,Inputs.getSsn());
		String stateName=response.getBody();
		if(stateName.equalsIgnoreCase(targetState)) {
			CitizenRegistrationEntity citizenRegistrationEntity=new CitizenRegistrationEntity();
			BeanUtils.copyProperties(Inputs, citizenRegistrationEntity);
			citizenRegistrationEntity.setStateName(targetState);
			int appId=IApplicationRegistrationRepo.save(citizenRegistrationEntity).getAppld();
			return appId;
		}
		
		return 0;
	}

}
