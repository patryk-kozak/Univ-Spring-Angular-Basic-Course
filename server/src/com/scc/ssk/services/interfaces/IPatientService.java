package com.scc.ssk.services.interfaces;

import java.text.ParseException;
import java.util.List;

import com.scc.ssk.model.Patient;
import com.scc.ssk.model.json.PatientJSON;

public interface IPatientService {
	Patient findById(Integer id);
	List<Patient> findAll();
	void store(PatientJSON candidate) throws ParseException;
	void delete(Patient object);
	void update(Patient candidate);
	List<Patient> findByDoctorId(Integer id);
}
