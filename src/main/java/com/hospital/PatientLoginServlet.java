package com.hospital;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class PatientLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate login
        int patientId = PatientDAO.validateLogin(email, password);

        if (patientId > 0) { // means valid user found
            HttpSession session = request.getSession();
            session.setAttribute("patientId", patientId);

            String patientName = PatientDAO.getPatientName(patientId);
            session.setAttribute("patientName", patientName);

            response.sendRedirect("bookAppointment.jsp");
        } else {
            response.sendRedirect("patientLogin.jsp?msg=invalid");
        }
    }
}
