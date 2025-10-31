package com.hospital;

public class Patient {
    private Integer patientId;
    private String name;
    private String age;
    private String dob;
    private String gender;
    private String disease;
    private String email;
    private String password;
    private Long contact;
    private String bloodGroup;
    private String lastVisit;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(Integer patientId, String name, String age, String dob, String gender, String disease, String email,
			String password, Long contact, String bloodGroup, String lastVisit) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.dob = dob;
		this.gender = gender;
		this.disease = disease;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.bloodGroup = bloodGroup;
		this.lastVisit = lastVisit;
	}
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(String lastVisit) {
		this.lastVisit = lastVisit;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", age=" + age + ", dob=" + dob + ", gender="
				+ gender + ", disease=" + disease + ", email=" + email + ", password=" + password + ", contact="
				+ contact + ", bloodGroup=" + bloodGroup + ", lastVisit=" + lastVisit + "]";
	}

}
