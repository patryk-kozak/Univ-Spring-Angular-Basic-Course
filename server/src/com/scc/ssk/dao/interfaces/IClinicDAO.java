package com.scc.ssk.dao.interfaces;

import java.util.List;

import com.scc.ssk.model.Clinic;

public interface IClinicDAO {
	Clinic findById(Integer id);
	List<Clinic> findAll();
}
