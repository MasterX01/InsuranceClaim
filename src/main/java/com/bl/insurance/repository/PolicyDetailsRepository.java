package com.bl.insurance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.insurance.model.PolicyDetails;

@Repository
public interface PolicyDetailsRepository extends JpaRepository<PolicyDetails, Long>{
	List<PolicyDetails> findByUserId(Long id);

	Optional<PolicyDetails> findByUserIdAndPolicyNo(Long id, Long policyNo);
}
