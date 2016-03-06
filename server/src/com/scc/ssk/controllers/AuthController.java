package com.scc.ssk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scc.ssk.services.interfaces.IAuthService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

	@Autowired
	IAuthService authService;

	@RequestMapping(value = "/{code}/{isDoctor}", method = RequestMethod.GET)
	public ResponseEntity<Object> logIn(@PathVariable(value = "code") String code,
			@PathVariable(value = "isDoctor") boolean isDoctor) {
		return new ResponseEntity<Object>(authService.logIn(code, isDoctor), HttpStatus.OK);
	}

}
