package com.hospital;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
public class UpdatePatientServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Read all string parameters directly
        Integer patientId = Integer.parseInt(request.getParameter("patient_id"));
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String bloodGroup = request.getParameter("blood_group");
        String disease = request.getParameter("disease");
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String lastVisit = request.getParameter("last_visit");
        String contactStr = request.getParameter("contact_no");

        // ✅ Convert contact only if valid (simple check)
        Long contact = null;
        if (contactStr != null && contactStr.matches("\\d{10}")) {
            contact = Long.parseLong(contactStr);
        }

        // Create and set Patient object
        Patient patient = new Patient();
        patient.setPatientId(patientId);
        patient.setName(name);
        patient.setAge(age);
        patient.setGender(gender);
        patient.setBloodGroup(bloodGroup);
        patient.setDisease(disease);
        patient.setEmail(email);
        patient.setContact(contact);
        patient.setDob(dob);
        patient.setLastVisit(lastVisit);

        // Save to DB
        boolean updated = PatientDAO.updatePatient(patient);

        // Response handling
        if (updated) {
            response.sendRedirect("PatientServlet"); // Success → go back to list
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<h3 style='color:red;text-align:center;'>Update failed!</h3>");
        }
    }
}
