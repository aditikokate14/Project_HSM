package com.hospital;

public class Doctor {
	private Integer doctorId;
    private String name;
    private String specialization;
    private String email;
    private Long contact;
    private String password;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(Integer doctorId, String name, String specialization, String email, Long contact, String password) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.specialization = specialization;
		this.email = email;
		this.contact = contact;
		this.password = password;
	}
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialization=" + specialization + ", email="
				+ email + ", contact=" + contact + ", password=" + password + "]";
	}
	
    
    
}
