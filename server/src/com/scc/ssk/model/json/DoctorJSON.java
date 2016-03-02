package com.scc.ssk.model.json;

public class DoctorJSON {
	
	private String firstName;
	private String lastName;
	private String profession;
	private ScheduleJSON scheduleId;
	private Integer clinicId;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Integer getClinicId() {
		return clinicId;
	}
	public void setClinicId(Integer clinicId) {
		this.clinicId = clinicId;
	}
	public ScheduleJSON getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(ScheduleJSON scheduleId) {
		this.scheduleId = scheduleId;
	}
	
}
