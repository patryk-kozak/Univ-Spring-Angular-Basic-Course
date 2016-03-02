package com.scc.ssk.dao.interfaces;

import java.util.List;

import com.scc.ssk.model.Patient;

public interface IPatientDAO {
	Patient findById(Integer id);
	List<Patient> findByDoctorId(Integer id);
	List<Patient> findAll();
	void store(Patient candidate);
	void delete(Patient object);
}
