package com.hospital;

import java.sql.Date;
import java.sql.Time;

public class Appointment {
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String patientname;
    private String doctorname;
    private String day;
    private Date appointmentDate;
    private Time appointmentTime;
	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appointment(int appointmentId, int patientId, int doctorId, String patientname, String doctorname,
			String day, Date appointmentDate, Time appointmentTime) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.patientname = patientname;
		this.doctorname = doctorname;
		this.day = day;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
	}
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Time getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", patientname=" + patientname + ", doctorname=" + doctorname + ", day=" + day + ", appointmentDate="
				+ appointmentDate + ", appointmentTime=" + appointmentTime + "]";
	}
    

   
    
    
}
