package com.bl.insurance.service;

import com.bl.insurance.dto.LoginSuccess;
import com.bl.insurance.dto.UserDTO;

public interface IUserService {

	LoginSuccess login(UserDTO user);
}
