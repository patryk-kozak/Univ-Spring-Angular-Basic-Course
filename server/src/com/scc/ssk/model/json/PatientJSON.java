package com.scc.ssk.model.json;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class PatientJSON {
	
	private String firstName;
	private String lastName;
	private String code;
	private Date visit;
	private Integer doctorId;
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	@JsonSerialize(using=DateSerializer.class)
	public Date getVisit() {
		return visit;
	}
	public void setVisit(Date visit) {
		this.visit = visit;
	}
}
