package com.rest.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.rest.login.DAO.LoginDAO;
import com.rest.login.model.Login;

/**
 * Created by Amit on 2021/11/7
 * Login REST end-point to authenticate the user using the basic authentication.
 * User details are hard-coded in the application.properties file.
 */

@RestController

public class LoginController {

	@Autowired
	private LoginDAO loginDAO;

	@GetMapping(value = "/login", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Login>> getlogin() {
		List<Login> list = loginDAO.getAllLogins();
		return new ResponseEntity<List<Login>>(list, HttpStatus.OK);
	}
}