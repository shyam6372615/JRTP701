package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.CitizenRegistrationEntity;

public interface IApplicationRegistrationRepository extends JpaRepository<CitizenRegistrationEntity, Integer> {

}
