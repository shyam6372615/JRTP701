package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.DcChildrenEntity;

public interface DcChildrenRepository extends JpaRepository<DcChildrenEntity, Integer> {
    public List<DcChildrenEntity>findByCaseNumber(Integer caseNumber);
}
