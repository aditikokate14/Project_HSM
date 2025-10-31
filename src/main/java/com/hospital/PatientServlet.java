package com.hospital;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

public class PatientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String search = request.getParameter("search");
        List<Patient> patients;

        if (search != null && !search.trim().isEmpty()) {
            patients = PatientDAO.searchPatients(search.trim());
        } else {
            patients = PatientDAO.getAllPatients();
        }

        request.setAttribute("patients", patients);
        RequestDispatcher rd = request.getRequestDispatcher("patientList.jsp");
        rd.forward(request, response);
    }
}
