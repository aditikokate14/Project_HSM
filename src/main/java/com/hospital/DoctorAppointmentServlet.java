package com.hospital;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

public class DoctorAppointmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int doctorId = Integer.parseInt(request.getParameter("doctorId"));

        // Get appointments for this doctor
        List<Appointment> appointments = AppointmentDAO.getAppointmentsByDoctorId(doctorId);

        // Optional: Get doctor name for heading
        String doctorName = DoctorDAO.getDoctorNameById(doctorId);
        
        request.setAttribute("appointments", appointments);
        request.setAttribute("doctorId", doctorId);
        request.setAttribute("doctorName", doctorName);

        RequestDispatcher rd = request.getRequestDispatcher("doctorAppointments.jsp");
        rd.forward(request, response);
    }
}
