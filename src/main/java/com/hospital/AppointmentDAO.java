package com.hospital;

import java.sql.*;
import java.util.*;

public class AppointmentDAO {

    // Fetch all appointments
    public static List<Appointment> getAllAppointments() {
        List<Appointment> list = new ArrayList<>();

        try (Connection con = DBConnection.getConnection()) {
            String query = "SELECT * FROM appointments ORDER BY appointment_date DESC, appointment_time DESC";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setPatientId(rs.getInt("patient_id"));
                a.setPatientname(rs.getString("patient_name"));
                a.setDoctorname(rs.getString("doctor_name"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setDay(rs.getString("day"));
                a.setAppointmentTime(rs.getTime("appointment_time"));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }



    // Get appointments for specific patient
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
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setPatientId(rs.getInt("patient_id"));
                a.setPatientname(rs.getString("patient_name"));
                a.setDoctorname(rs.getString("doctor_name"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setDay(rs.getString("day"));
                a.setAppointmentTime(rs.getTime("appointment_time"));
                list.add(a);
            }
            con.close();
        } catch(Exception e) { e.printStackTrace(); }
        return list;
    }

    // Add appointment
    public static boolean addAppointment(Appointment a) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
            		"INSERT INTO appointments (patient_id, doctor_id, patient_name, doctor_name, appointment_date,day, appointment_time) VALUES (?,?, ?, ?, ?,?, ?)"
            );
           
            ps.setInt(1, a.getPatientId());
            ps.setInt(2, a.getDoctorId());
            ps.setString(3, a.getPatientname());
            ps.setString(4, a.getDoctorname());
            ps.setDate(5, a.getAppointmentDate());
            ps.setString(6, a.getDay());
            ps.setTime(7, a.getAppointmentTime());

            if (ps.executeUpdate() > 0) status = true;
            con.close();
        } catch(Exception e) { e.printStackTrace(); }
        return status;
    }

    // Delete appointment
    public static boolean deleteAppointment(int appointmentId) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM appointments WHERE appointment_id=?"
            );
            ps.setInt(1, appointmentId);
            status = ps.executeUpdate() > 0;
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    public static List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        List<Appointment> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM appointments WHERE doctor_id = ? ORDER BY appointment_date DESC"
            );
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setPatientId(rs.getInt("patient_id"));
                a.setDoctorId(rs.getInt("doctor_id"));
                a.setPatientname(rs.getString("patient_name"));
                a.setDoctorname(rs.getString("doctor_name"));
                a.setDay(rs.getString("day"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setAppointmentTime(rs.getTime("appointment_time"));
                list.add(a);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Appointment> searchAppointments(String keyword) {
        List<Appointment> list = new ArrayList<>();

        // Allow partial matches using LIKE
        String sql = "SELECT * FROM appointments WHERE patient_name LIKE ? OR doctor_name LIKE ?";

        try {
        	Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            // Add wildcards for partial search
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
           

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment a = new Appointment();
                a.setAppointmentId(rs.getInt("appointment_id"));
                a.setPatientname(rs.getString("patient_name"));
                a.setDoctorname(rs.getString("doctor_name"));
                a.setAppointmentDate(rs.getDate("appointment_date"));
                a.setDay(rs.getString("day"));
                a.setAppointmentTime(rs.getTime("appointment_time"));
                list.add(a);
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    
}
