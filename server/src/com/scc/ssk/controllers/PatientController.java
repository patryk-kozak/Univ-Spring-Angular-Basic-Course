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

import com.scc.ssk.model.Patient;
import com.scc.ssk.model.json.PatientJSON;
import com.scc.ssk.services.interfaces.IPatientService;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

	@Autowired
	IPatientService patientService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Patient>> getAllPatients()
	{
		return new ResponseEntity<List<Patient>>(patientService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<HttpStatus> createPatient(@RequestBody PatientJSON patient) throws ParseException
	{
		patientService.store(patient);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable(value = "id") Integer patientId)
	{
		return new ResponseEntity<Patient>(patientService.findById(patientId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/doctor/{id}")
	public ResponseEntity<List<Patient>> getPatientsByDoctor(@PathVariable(value = "id") Integer doctorId)
	{
		return new ResponseEntity<List<Patient>>(patientService.findByDoctorId(doctorId), HttpStatus.OK);
	}
	
}
