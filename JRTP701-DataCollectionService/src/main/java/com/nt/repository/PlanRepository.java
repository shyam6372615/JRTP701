package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Integer> {

}
