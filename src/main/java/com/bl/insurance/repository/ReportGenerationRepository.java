package com.bl.insurance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.insurance.model.ReportGeneration;

@Repository
public interface ReportGenerationRepository extends JpaRepository<ReportGeneration, Long>{
	
    Optional<ReportGeneration> findByClaimNo(Long claimNumber);

}
