package com.bl.insurance.service;

import com.bl.insurance.dto.SignupDTO;
import com.bl.insurance.model.User;

public interface IClaimAdjusterService {
	
    User firstClaimAdjuster(SignupDTO signUpDTO);

    User userRegistration(String token,SignupDTO signUpDTO);

}
