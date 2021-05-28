package com.bl.insurance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.insurance.model.ClaimPolicy;

@Repository
public interface ClaimPolicyRepository extends JpaRepository<ClaimPolicy, Long> {
	Optional<ClaimPolicy> findByClaimNumber(Long claimNumber);

	Optional<ClaimPolicy> findByPolicyNumber(Long policyNumber);

}
