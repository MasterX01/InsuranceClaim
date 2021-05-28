package com.bl.insurance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bl.insurance.dto.DecodedToken;
import com.bl.insurance.dto.SignupDTO;
import com.bl.insurance.exception.UserException;
import com.bl.insurance.model.User;
import com.bl.insurance.repository.IUserRepository;
import com.bl.insurance.utility.TokenGenerator;

@Service
public class ClaimAdjusterService implements IClaimAdjusterService{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private TokenGenerator tokenGenerator;
	
	@Override
	public User firstClaimAdjuster(SignupDTO signUpDTO) {
		if(userRepo.count() == 0) {
            User userData = new User(signUpDTO);
            userData.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
            userData.setRoleId("ClaimAdjuster");
            return userRepo.save(userData);
        }else
            throw new UserException("Only Claim Adjuster can register users");	
	}

	@Override
	public User userRegistration(String token, SignupDTO signUpDTO) {
		DecodedToken decode = tokenGenerator.decodeToken(token);
		if(decode.getRole() != "ClaimAdjuster") {
			throw new UserException("Only Claim Adjuster can register users");
		}
        Optional<User> byUserName = userRepo.findByUsername(signUpDTO.getUsername());
        if (byUserName.isPresent()) {
        	throw new UserException("User Already Exists");
        }
        User userData = new User(signUpDTO);
        userData.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        return userRepo.save(userData);
        
	}

}
