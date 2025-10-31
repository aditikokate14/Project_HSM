package com.hospital;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String mobilestr = request.getParameter("mobile");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hospital_name = request.getParameter("hospital_name");

        // ✅ Validate 10-digit mobile number
        if (mobilestr == null || !mobilestr.matches("\\d{10}")) {
            request.setAttribute("errorMessage", "Mobile number must be exactly 10 digits.");
            RequestDispatcher rd = request.getRequestDispatcher("Resistration.jsp");
            rd.forward(request, response);
            return;
        }

        long mobile = Long.parseLong(mobilestr);

        int status = RegistrationDAO.save(name, mobile, email, password, hospital_name);

        if (status > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            RequestDispatcher rd = request.getRequestDispatcher("Resistration.jsp");
            rd.forward(request, response);
        }
    }
}
