package com.scc.ssk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scc.ssk.dao.interfaces.IClinicDAO;
import com.scc.ssk.model.Clinic;
import com.scc.ssk.services.interfaces.IClinicService;

@Service
@Transactional
public class ClinicService implements IClinicService {

	@Autowired
	IClinicDAO clinicDAO;
	
	@Override
	public Clinic findById(Integer id) {
		return clinicDAO.findById(id);
	}

	@Override
	public List<Clinic> findAll() {
		return clinicDAO.findAll();
	}

}
