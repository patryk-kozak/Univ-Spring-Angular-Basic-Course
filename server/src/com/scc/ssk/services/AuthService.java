package com.scc.ssk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scc.ssk.dao.interfaces.IDoctorDAO;
import com.scc.ssk.dao.interfaces.IPatientDAO;
import com.scc.ssk.services.interfaces.IAuthService;

@Service
@Transactional
public class AuthService implements IAuthService {

	@Autowired
	IPatientDAO patientDAO;
	
	@Autowired
	IDoctorDAO doctorDAO;
	
	@Override
	public Object logIn(String code, boolean isDoctor) {
		if(isDoctor)
		{
			return doctorDAO.findByCode(code);
		}
		else 
		{
			return patientDAO.findByCode(code);
		}
	}

}
