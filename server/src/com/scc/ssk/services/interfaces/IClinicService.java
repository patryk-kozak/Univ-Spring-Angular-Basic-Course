package com.scc.ssk.services.interfaces;

import java.util.List;

import com.scc.ssk.model.Clinic;

public interface IClinicService {
	
	Clinic findById(Integer id);
	List<Clinic> findAll();
}
