package com.scc.ssk.services.interfaces;

import java.text.ParseException;
import java.util.List;

import com.scc.ssk.model.Doctor;
import com.scc.ssk.model.json.DoctorJSON;

public interface IDoctorService {
	Doctor findById(Integer id);
	List<Doctor> findAll();
	void store(DoctorJSON candidate) throws ParseException;
	void delete(Doctor object);
	void update(Doctor candidate);
}
