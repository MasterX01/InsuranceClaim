package com.bl.insurance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bl.insurance.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{
	
	User getByUsername(String username);

}
