package com.scc.ssk.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.scc.ssk.dao.interfaces.IDoctorScheduleDAO;
import com.scc.ssk.model.DoctorSchedule;

@Repository
public class DoctorScheduleDAO extends BaseDAO<Integer, DoctorSchedule> implements IDoctorScheduleDAO {

	@Override
	public DoctorSchedule findById(Integer id) {
		return getByKey(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DoctorSchedule> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<DoctorSchedule>)criteria.list();
	}

	@Override
	public void store(DoctorSchedule candidate) {
		persist(candidate);
	}

	@Override
	public void delete(DoctorSchedule object) {
		remove(object);
	}

}
