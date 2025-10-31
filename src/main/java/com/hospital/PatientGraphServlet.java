package com.hospital;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/PatientGraphServlet")
public class PatientGraphServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Patient> patients = PatientDAO.getAllPatients(); // assume your DAO exists

        int male = 0, female = 0;
        for (Patient p : patients) {
            if (p.getGender().equalsIgnoreCase("Male")) male++;
            else if (p.getGender().equalsIgnoreCase("Female")) female++;
        }

        request.setAttribute("maleCount", male);
        request.setAttribute("femaleCount", female);
        request.getRequestDispatcher("patientGraph.jsp").forward(request, response);
    }
}
