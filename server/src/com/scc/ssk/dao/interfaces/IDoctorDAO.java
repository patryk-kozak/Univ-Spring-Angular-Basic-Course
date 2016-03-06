package com.scc.ssk.dao.interfaces;

import java.util.List;

import com.scc.ssk.model.Doctor;

public interface IDoctorDAO {
	Doctor findById(Integer id);
	Doctor findByCode(String code);
	List<Doctor> findAll();
	void store(Doctor candidate);
	void delete(Doctor object);
	void update(Doctor candidate);
}
