package com.scc.ssk.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scc.ssk.dao.interfaces.IClinicDAO;
import com.scc.ssk.dao.interfaces.IDoctorDAO;
import com.scc.ssk.dao.interfaces.IDoctorScheduleDAO;
import com.scc.ssk.model.Doctor;
import com.scc.ssk.model.json.DoctorJSON;
import com.scc.ssk.services.interfaces.IDoctorService;

@Service
@Transactional
public class DoctorService implements IDoctorService {

	@Autowired
	IDoctorDAO doctorDAO;
	IClinicDAO clinicDAO;
	IDoctorScheduleDAO scheduleDAO;
	
	@Override
	public Doctor findById(Integer id) {
		return doctorDAO.findById(id);
	}

	@Override
	public List<Doctor> findAll() {
		return doctorDAO.findAll();
	}

	@Override
	public void store(DoctorJSON candidate) throws ParseException {
		Doctor doctor = Doctor.fromJSON(candidate,
				clinicDAO.findById(candidate.getClinicId()),
				scheduleDAO.findById(candidate.getScheduleId().getId()));
		doctorDAO.store(doctor);
	}

	@Override
	public void delete(Doctor object) {
		doctorDAO.delete(object);
	}

	@Override
	public void update(Doctor candidate) {
		doctorDAO.update(candidate);
	}

	
	
}
