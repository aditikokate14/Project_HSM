package com.hospital;

import java.sql.*;
import java.sql.Date;
import java.util.*;


public class PatientDAO {

    public static boolean patientExists(String email) {
        boolean exists = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
        } catch (Exception e) { e.printStackTrace(); }
        return exists;
    }

    public static int save(String name, String age, String gender,
                           String bloodGroup, String disease, String email, String password,
                           Long contact, String dob, String lastVisit) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO patients(name, age, contact_no, dob, last_visit, gender, blood_group, disease, email, password) VALUES (?,?,?,?,?,?,?,?,?,?)"
            );
            
            ps.setString(1, name);
            ps.setString(2, age);
            ps.setLong(3, contact);
            ps.setDate(4, java.sql.Date.valueOf(dob));
            ps.setDate(5, java.sql.Date.valueOf(lastVisit));
            ps.setString(6, gender);
            ps.setString(7, bloodGroup);
            ps.setString(8, disease);
            ps.setString(9, email);
            ps.setString(10, password);

            status = ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
        return status;
    }

    public static boolean login(String patientId, String password) {
        boolean valid = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE patient_id=? AND password=?");
            ps.setString(1, patientId);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            valid = rs.next();
        } catch (Exception e) { e.printStackTrace(); }
        return valid;
    }

    public static List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getString("age"));
                p.setGender(rs.getString("gender"));
                p.setBloodGroup(rs.getString("blood_group"));
                p.setDisease(rs.getString("disease"));
                p.setEmail(rs.getString("email"));
                p.setDob(rs.getString("dob"));
                p.setContact(rs.getLong("contact_no"));
                p.setLastVisit(rs.getString("last_visit"));
                list.add(p);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    
    
    public static Patient getPatientById(String id) {
        Patient p = null;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM patients WHERE patient_id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getString("age"));
                p.setGender(rs.getString("gender"));
                p.setBloodGroup(rs.getString("blood_group"));
                p.setDisease(rs.getString("disease"));
                p.setEmail(rs.getString("email"));
                p.setContact(rs.getLong("contact_no"));
                p.setDob(rs.getString("dob"));
                p.setLastVisit(rs.getString("last_visit"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    
    public static boolean updatePatient(Patient p) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "UPDATE patients SET name=?, age=?, gender=?, blood_group=?, disease=?, email=?, contact_no=?, dob=?, last_visit=? WHERE patient_id=?"
            );
            ps.setString(1, p.getName());
            ps.setString(2, p.getAge());
            ps.setString(3, p.getGender());
            ps.setString(4, p.getBloodGroup());
            ps.setString(5, p.getDisease());
            ps.setString(6, p.getEmail());
            ps.setLong(7, p.getContact());
            ps.setString(8, p.getDob());
            ps.setString(9, p.getLastVisit());
            ps.setInt(10, p.getPatientId());

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public int delete(Patient p) {
		int res=0;
		try {
			Connection con=DBConnection.getConnection();
			
			PreparedStatement pst=con.prepareStatement("delete from patients where patient_id=?");
			pst.setInt(1, p.getPatientId());
			res=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res; 
	}
    
    
    
    public static int validateLogin(String email, String password) {
        int patientId = 0; // 0 = invalid login
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT patient_id FROM patients WHERE TRIM(email)=TRIM(?) AND TRIM(password)=TRIM(?)"
            );
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                patientId = rs.getInt("patient_id");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientId;
    }



    public static boolean bookAppointment(int patientId, String patientName, String doctorName, Date date, Time time) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO appointments(patient_id, patient_name, doctor_name, appointment_date, appointment_time) VALUES(?,?,?,?,?)"
            );
            ps.setInt(1, patientId);
            ps.setString(2, patientName);
            ps.setString(3, doctorName);
            ps.setDate(4, date);
            ps.setTime(5, time);
            int rows = ps.executeUpdate();
            if(rows > 0) status = true;
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    // Get appointments by patientId
    public static List<Appointment> getAppointmentsByPatientId(int patientId) {
        List<Appointment> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM appointments WHERE patient_id=? ORDER BY appointment_date DESC"
            );
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Appointment appt = new Appointment();
                appt.setAppointmentId(rs.getInt("appointment_id"));
                appt.setPatientname(rs.getString("patient_name"));
                appt.setDoctorname(rs.getString("doctor_name"));
                appt.setAppointmentDate(rs.getDate("appointment_date"));
                appt.setAppointmentTime(rs.getTime("appointment_time"));
                list.add(appt);
            }
            con.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Optional: get patient name by Id
    public static String getPatientName(int patientId) {
        String name = "";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT name FROM patients WHERE patient_id=?"
            );
            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    public static List<Patient> searchPatients(String keyword) {
        List<Patient> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM patients WHERE name LIKE ? OR email LIKE ? OR disease LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patient p = new Patient();
                p.setPatientId(rs.getInt("patient_id"));
                p.setName(rs.getString("name"));
                p.setAge(rs.getString("age"));
                p.setGender(rs.getString("gender"));
                p.setBloodGroup(rs.getString("blood_group"));
                p.setDisease(rs.getString("disease"));
                p.setEmail(rs.getString("email"));
                p.setContact(rs.getLong("contact_no"));
                p.setDob(rs.getString("dob"));
                p.setLastVisit(rs.getString("last_visit"));
                list.add(p);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    
    
    
}
