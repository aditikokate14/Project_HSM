package com.hospital;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DeleteDoctorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String doctorId = req.getParameter("doctor_id");
        if (DoctorDAO.deleteDoctorById(doctorId)) {
            res.sendRedirect("DoctorServlet");
        } else {
            res.getWriter().println("<h3>Failed to delete doctor!</h3>");
        }
    }
}
