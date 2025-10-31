package com.hospital;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class DashboardPatientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<Appointment> patients = DashboardDAO.getAllAppointments();
        req.setAttribute("patients", patients);

        RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
        rd.forward(req, res);
    }
}
