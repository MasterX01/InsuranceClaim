package com.bl.insurance.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bl.insurance.dto.LoginSuccess;
import com.bl.insurance.dto.UserDTO;
import com.bl.insurance.exception.UserException;
import com.bl.insurance.model.User;
import com.bl.insurance.repository.IUserRepository;
import com.bl.insurance.utility.TokenGenerator;

@Service
public class UserService implements IUserService{
	
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private TokenGenerator token;
    
	@Autowired
	private IUserRepository userRepo;
	
	@Override
	public LoginSuccess login(UserDTO user) {
		User users = userRepo.getByUsername(user.getUsername());
		if(users == null) {
			throw new UserException("No Such User Found");
		}else {
			return authenticate(users, user.getPassword());
		}
	}
	
	private LoginSuccess authenticate(User user, String password) {
        LoginSuccess login = new LoginSuccess();
        boolean status = passwordEncoder.matches(password, user.getPassword());
        if (status == true) {
        	String generatedToken = token.createToken(user.getUserId(), user.getRoleId());
            login.setToken(generatedToken);
            login.setMessage("User Logged In Successfully");
            login.setObj(user);
            return login;
        }
            throw new UserException("Invalid UserName Or Password");
    }

}
