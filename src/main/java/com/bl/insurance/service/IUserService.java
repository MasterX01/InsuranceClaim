package com.bl.insurance.service;

import org.springframework.stereotype.Service;

import com.bl.insurance.dto.LoginSuccess;
import com.bl.insurance.dto.ResponseDTO;
import com.bl.insurance.dto.UserDTO;

public interface IUserService {

	LoginSuccess login(UserDTO user);
}
