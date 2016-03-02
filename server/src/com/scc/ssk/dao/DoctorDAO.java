package com.scc.ssk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.scc.ssk.dao.interfaces.IDoctorDAO;
import com.scc.ssk.model.Doctor;

@Repository
public class DoctorDAO extends BaseDAO<Integer, Doctor> implements IDoctorDAO {

	@Override
	public Doctor findById(Integer id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doctor> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<Doctor>)criteria.list();
	}

	@Override
	public void store(Doctor candidate) {
		persist(candidate);
	}

	@Override
	public void delete(Doctor object) {
		remove(object);
	}

	@Override
	public void update(Doctor candidate)
	{
		update(candidate);
	}
}
