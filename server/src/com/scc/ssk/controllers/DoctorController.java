package com.scc.ssk.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.scc.ssk.model.Doctor;
import com.scc.ssk.model.json.DoctorJSON;
import com.scc.ssk.services.interfaces.IDoctorService;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

	@Autowired
	IDoctorService doctorService;
	
	@RequestMapping(value = "/", method= RequestMethod.GET)
	public ResponseEntity<List<Doctor>> findAllDoctors()
	{
		return new ResponseEntity<List<Doctor>>(doctorService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Doctor> findById(@PathVariable(value = "id") Integer doctorId)
	{
		return new ResponseEntity<Doctor>(doctorService.findById(doctorId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> createDoctor(@RequestBody DoctorJSON doctorJSON) throws ParseException
	{
		doctorService.store(doctorJSON);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
