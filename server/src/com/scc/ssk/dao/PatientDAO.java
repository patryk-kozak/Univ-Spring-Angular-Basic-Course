package com.scc.ssk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.scc.ssk.dao.interfaces.IPatientDAO;
import com.scc.ssk.model.Patient;

@Repository
public class PatientDAO extends BaseDAO<Integer, Patient> implements IPatientDAO {

	@Override
	public Patient findById(Integer id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Patient>)criteria.list();
	}

	@Override
	public void store(Patient candidate) {
		persist(candidate);
	}

	@Override
	public void delete(Patient object) {
		remove(object);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findByDoctorId(Integer id) {
		Criteria criteria = createEntityCriteria()
				.createAlias("doctor", "d")
				.add(Restrictions.eq("d.id", id))
				.addOrder(Order.asc("firstName"));
		return criteria.list();
	}

}
