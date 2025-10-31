package com.hospital;

import java.io.IOException;
import java.sql.*;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;


public class BookAppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer patientId = (Integer) session.getAttribute("patientId");
        String patientName = (String) session.getAttribute("patientName");

        if (patientId == null || patientName == null) {
            response.sendRedirect("patientLogin.jsp");
            return;
        }

        try {
            // ✅ Get doctorId from dropdown
            int doctorId = Integer.parseInt(request.getParameter("doctorId"));
            String dateStr = request.getParameter("date");
            String timeStr = request.getParameter("time");

            // ✅ Convert date and find day
            Date appointmentDate = Date.valueOf(dateStr);
            LocalDate localDate = appointmentDate.toLocalDate();
            DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            String day = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            // ✅ Convert time
            Time appointmentTime = Time.valueOf(timeStr + ":00");

            // ✅ Fetch doctor name using doctorId
            String doctorName = "";
            try (Connection con = DBConnection.getConnection();
                 PreparedStatement ps = con.prepareStatement("SELECT name FROM doctors WHERE doctor_id = ?")) {
                ps.setInt(1, doctorId);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    doctorName = rs.getString("name");
                }
            }

            // ✅ Create appointment object
            Appointment appointment = new Appointment();
            appointment.setPatientId(patientId);
            appointment.setPatientname(patientName);
            appointment.setDoctorId(doctorId);
            appointment.setDoctorname(doctorName);
            appointment.setAppointmentDate(appointmentDate);
            appointment.setDay(day);
            appointment.setAppointmentTime(appointmentTime);

            // ✅ Save to DB
            boolean booked = AppointmentDAO.addAppointment(appointment);

            if (booked) {
                response.sendRedirect("bookAppointment.jsp?msg=Appointment booked successfully!");
            } else {
                response.sendRedirect("bookAppointment.jsp?msg=Failed to book appointment.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("bookAppointment.jsp?msg=Error: Invalid data or server error.");
        }
    }
}
