package com.hospital;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class PatientRegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String dob = req.getParameter("dob");
        String lastVisit = req.getParameter("last_visit");
        String gender = req.getParameter("gender");
        String bloodGroup = req.getParameter("blood_group");
        String disease = req.getParameter("disease");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String contactStr = req.getParameter("contact_no");

        Long contact = 0L;

        // ✅ Validate contact number (must be 10 digits)
        if (contactStr != null && contactStr.matches("\\d{10}")) {
            contact = Long.parseLong(contactStr);
        } else {
            req.setAttribute("message", "<p style='color:red;text-align:center;'>Contact number must be 10 digits!</p>");
            RequestDispatcher rd = req.getRequestDispatcher("patientRegister.jsp");
            rd.forward(req, res);
            return;
        }

        try {
            if (PatientDAO.patientExists(email)) {
                req.setAttribute("message", "<p style='color:red;text-align:center;'>Patient already registered! <a href='patientLogin.jsp'>Login here</a></p>");
            } else {
                int status = PatientDAO.save(name, age, gender, bloodGroup, disease, email, password, contact, dob, lastVisit);
                if (status > 0) {
                    req.setAttribute("message", "<p style='color:green;text-align:center;'>Registration successful!</p>");
                } else {
                    req.setAttribute("message", "<p style='color:red;text-align:center;'>Registration failed! Please try again.</p>");
                }
            }

            RequestDispatcher rd = req.getRequestDispatcher("patientRegister.jsp");
            rd.forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "<p style='color:red;text-align:center;'>Error occurred. Please try again.</p>");
            RequestDispatcher rd = req.getRequestDispatcher("patientRegister.jsp");
            rd.forward(req, res);
        }
    }
}
