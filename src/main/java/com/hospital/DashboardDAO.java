package com.hospital;

import java.sql.*;
import java.util.*;

public class DashboardDAO {
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
                a.setAppointmentTime(rs.getTime("appointment_time"));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }



    public static int getDoctorCount() {
        return getCount("SELECT COUNT(*) FROM doctors");
    }

    public static int getPatientCount() {
        return getCount("SELECT COUNT(*) FROM patients");
    }

    public static int getAppointmentCount() {
        return getCount("SELECT COUNT(*) FROM appointments");
    }

    private static int getCount(String query) {
        int count = 0;
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) count = rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    
    public static Map<String, Integer> getPatientVisitsPerDay() {
        Map<String, Integer> visits = new LinkedHashMap<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = """
                SELECT DATE(appointment_date) AS visit_day, COUNT(*) AS count
                FROM appointments
                GROUP BY DATE(appointment_date)
                ORDER BY DATE(appointment_date);
            """;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                visits.put(rs.getString("visit_day"), rs.getInt("count"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return visits;
    }


    
}
