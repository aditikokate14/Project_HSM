package com.hospital;

import java.sql.*;
import java.util.*;

public class DoctorDAO {

    public static boolean doctorExists(String doctorId) {
        boolean exists = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM doctors WHERE doctor_id=?");
            ps.setString(1, doctorId);
            ResultSet rs = ps.executeQuery();
            exists = rs.next();
        } catch (Exception e) { e.printStackTrace(); }
        return exists;
    }

    public static boolean save(String name, String specialization, String email, Long contact, String password) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO doctors(name, specialization, email, contact,password) VALUES(?,?,?,?,?)"
            );
            
            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.setString(3, email);
            ps.setLong(4, contact);
            ps.setString(5, password);

            int rows = ps.executeUpdate();
            if (rows > 0) status = true;
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
        return status;
    }

    public static List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM doctors");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setEmail(rs.getString("email"));
                d.setContact(rs.getLong("contact"));
                list.add(d);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public static boolean deleteDoctorById(String doctorId) {
        boolean status = false;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM doctors WHERE doctor_id=?");
            ps.setString(1, doctorId);
            int rows = ps.executeUpdate();
            if (rows > 0) status = true;
            con.close();
        } catch (Exception e) { e.printStackTrace(); }
        return status;
    }
    
    public static List<Doctor> searchDoctors(String keyword) {
        List<Doctor> list = new ArrayList<>();
        try {
        	Connection con = DBConnection.getConnection();
            String sql = "SELECT * FROM doctors WHERE name LIKE ? OR specialization LIKE ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor d = new Doctor();
                d.setDoctorId(rs.getInt("doctor_id"));
                d.setName(rs.getString("name"));
                d.setSpecialization(rs.getString("specialization"));
                d.setEmail(rs.getString("email"));
                d.setContact(rs.getLong("contact"));
                list.add(d);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static String getDoctorNameById(int doctorId) {
        String doctorName = "";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT name FROM doctors WHERE doctor_id = ?"
            );
            ps.setInt(1, doctorId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                doctorName = rs.getString("name");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctorName;
    }

    public static Doctor validateDoctor(String email, String password) {
        Doctor doctor = null;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM doctors WHERE email = ? AND password = ?"
            );
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                doctor = new Doctor();
                doctor.setDoctorId(rs.getInt("doctor_id"));
                doctor.setName(rs.getString("name"));
                doctor.setEmail(rs.getString("email"));
                doctor.setSpecialization(rs.getString("specialization"));
                doctor.setContact(rs.getLong("contact"));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doctor;
    }



}
