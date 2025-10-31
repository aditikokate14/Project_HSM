package com.hospital;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
public class EditPatientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String patientIdStr = request.getParameter("patient_id");
        if (patientIdStr == null || patientIdStr.isEmpty()) {
            response.getWriter().println("<h3 style='color:red;'>Invalid patient ID!</h3>");
            return;
        }

        try {
            int patientId = Integer.parseInt(patientIdStr);

            // ✅ Fetch patient by ID using DAO
            Patient patient = PatientDAO.getPatientById(String.valueOf(patientId));

            if (patient != null) {
                request.setAttribute("patient", patient);
                RequestDispatcher rd = request.getRequestDispatcher("editPatient.jsp");
                rd.forward(request, response);
            } else {
                response.getWriter().println("<h3 style='color:red;'>Patient not found!</h3>");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("<h3 style='color:red;'>Invalid patient ID format!</h3>");
        }
    }
}
