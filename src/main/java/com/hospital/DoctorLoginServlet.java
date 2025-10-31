package com.hospital;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DoctorLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Doctor doctor = DoctorDAO.validateDoctor(email, password);

        if (doctor != null) {
            HttpSession session = request.getSession();
            session.setAttribute("doctorId", doctor.getDoctorId());
            session.setAttribute("doctorName", doctor.getName());

            // ✅ FIX: Send doctorId in the URL
            response.sendRedirect("DoctorAppointmentServlet?doctorId=" + doctor.getDoctorId());
        } else {
            response.sendRedirect("doctorLogin.jsp?msg=Invalid Email or Password");
        }
    }
}
