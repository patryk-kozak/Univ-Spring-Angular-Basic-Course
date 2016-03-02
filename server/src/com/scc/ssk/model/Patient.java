package com.scc.ssk.model;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.scc.ssk.model.json.PatientJSON;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table ( name = "patient", catalog = "mydb")
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2980670906050886247L;

	public final static Patient fromJSON(PatientJSON insert, Doctor doctor) throws ParseException
	{
		Patient patient = new Patient();
		patient.setFirstName(insert.getFirstName());
		patient.setLastName(insert.getLastName());
		patient.setCode(insert.getCode());
		patient.setVisit(insert.getVisit());
		patient.setDoctor(doctor);
		return patient;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idPatient", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "patientCode", nullable = false)
	private String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "visitDate", nullable = false)
	private Date visit;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Doctor_idDoctor")
	private Doctor doctor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getVisit() {
		return visit;
	}

	public void setVisit(Date visit) {
		this.visit = visit;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
}
