package com.scc.ssk.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scc.ssk.dao.interfaces.IDoctorDAO;
import com.scc.ssk.dao.interfaces.IPatientDAO;
import com.scc.ssk.model.Patient;
import com.scc.ssk.model.json.PatientJSON;
import com.scc.ssk.services.interfaces.IPatientService;

@Service
@Transactional
public class PatientService implements IPatientService {

	@Autowired
	IPatientDAO patientDAO;
	IDoctorDAO doctorDAO;
	
	@Override
	public Patient findById(Integer id) {
		return patientDAO.findById(id);
	}

	@Override
	public List<Patient> findAll() {
		return patientDAO.findAll();
	}

	@Override
	public void store(PatientJSON patientJson) throws ParseException {
		Patient candidate = Patient.fromJSON(patientJson, doctorDAO.findById(patientJson.getDoctorId()));
		patientDAO.store(candidate);
	}

	@Override
	public void delete(Patient object) {
		patientDAO.delete(object);
	}

	@Override
	public void update(Patient candidate) {
		Patient entity = patientDAO.findById(candidate.getId());
		if(entity != null)
		{
			entity.setCode(candidate.getCode());
			entity.setDoctor(candidate.getDoctor());
			entity.setFirstName(candidate.getFirstName());
			entity.setLastName(candidate.getLastName());
			entity.setVisit(candidate.getVisit());
		}
	}

	@Override
	public List<Patient> findByDoctorId(Integer id) {
		return patientDAO.findByDoctorId(id);
	}

}
