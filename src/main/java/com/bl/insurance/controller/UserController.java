package com.bl.insurance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.insurance.dto.LoginSuccess;
import com.bl.insurance.dto.ResponseDTO;
import com.bl.insurance.dto.UserDTO;
import com.bl.insurance.exception.UserException;
import com.bl.insurance.service.IUserService;

/**
 * Controller for user to login
 * @author Akash Saxena
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<ResponseDTO> login(@Valid @RequestBody UserDTO userDTO){
		try{
			LoginSuccess token = userService.login(userDTO);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(token, " Login Successfull!!! "), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
