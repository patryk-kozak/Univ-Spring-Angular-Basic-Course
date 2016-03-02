package com.scc.ssk.dao.interfaces;

import java.util.List;

import com.scc.ssk.model.DoctorSchedule;

public interface IDoctorScheduleDAO {
	DoctorSchedule findById(Integer id);
	List<DoctorSchedule> findAll();
	void store(DoctorSchedule candidate);
	void delete(DoctorSchedule object);
}
