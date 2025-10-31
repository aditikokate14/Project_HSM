package com.hospital;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int doctorCount = DashboardDAO.getDoctorCount();
        int patientCount = DashboardDAO.getPatientCount();
        int appointmentCount = DashboardDAO.getAppointmentCount();
        int cancelCount = 0; 
        List<Appointment> appointments = AppointmentDAO.getAllAppointments();

        System.out.println("Appointments fetched: " + appointments.size()); // debug check

        req.setAttribute("doctorCount", doctorCount);
        req.setAttribute("patientCount", patientCount);
        req.setAttribute("appointmentCount", appointmentCount);
        req.setAttribute("cancelCount", cancelCount);
        req.setAttribute("appointments", appointments);
        req.setAttribute("doctors", DoctorDAO.getAllDoctors());
        req.setAttribute("patients", PatientDAO.getAllPatients());
        


        RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
        rd.forward(req, res);
    }
}
