package com.hospital;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DoctorRegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String specialization = req.getParameter("specialization");
        String email = req.getParameter("email");
        String contactStr = req.getParameter("contact"); // ✅ use String first
        String password = req.getParameter("password");  // ✅ fixed wrong usage

        try {
            // ✅ Validate contact number (10 digits)
            if (contactStr == null || !contactStr.matches("\\d{10}")) {
                req.setAttribute("message", "<p style='color:red;text-align:center;'>Contact must be exactly 10 digits!</p>");
                RequestDispatcher rd = req.getRequestDispatcher("doctorRegister.jsp");
                rd.forward(req, res);
                return;
            }

            long contact = Long.parseLong(contactStr);

            if (DoctorDAO.doctorExists(email)) {
                req.setAttribute("message", "<p style='color:red;text-align:center;'>Doctor already registered!</p>");
            } else {
                boolean saved = DoctorDAO.save(name, specialization, email, contact, password);
                if (saved) {
                    req.setAttribute("message", "<p style='color:green;text-align:center;'>Registration successful!</p>");
                } else {
                    req.setAttribute("message", "<p style='color:red;text-align:center;'>Registration failed! Please try again.</p>");
                }
            }

            // ✅ Forward back to JSP page with message
            RequestDispatcher rd = req.getRequestDispatcher("doctorRegister.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
            res.getWriter().println("<h3 style='color:red;text-align:center;'>An error occurred. Please try again.</h3>");
        }
    }
}
