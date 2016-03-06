package com.scc.ssk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.scc.ssk.model.json.DoctorJSON;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.text.ParseException;

@Entity
@Table (name = "doctor", catalog = "mydb")
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3507063238941868311L;

	public final static Doctor fromJSON(DoctorJSON insert, Clinic clinic, DoctorSchedule schedule) throws ParseException
	{
		Doctor doctor = new Doctor();
		doctor.setFirstName(insert.getFirstName());
		doctor.setLastName(insert.getLastName());
		doctor.setClinic(clinic);
		doctor.setSchedule(schedule);
		doctor.setProfession(insert.getProfession());
		return doctor;
	}
	
	@Id
	@GeneratedValue (strategy = IDENTITY)
	@Column (name = "idDoctor", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "profession")
	private String profession;
	
	@Column(name = "doctorCode", unique = true)
	private String code;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Doctor_Schedule_idDoctor_Schedule")
	private DoctorSchedule schedule;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Clinic_idClinic")
	private Clinic clinic;

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

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public DoctorSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(DoctorSchedule schedule) {
		this.schedule = schedule;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
