package com.hospital;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DoctorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Doctor> doctors = DoctorDAO.getAllDoctors();
        String search = req.getParameter("search");
        List<Doctor> doctors1;
        if (search != null && !search.trim().isEmpty()) {
            doctors1 = DoctorDAO.searchDoctors(search); // create method in DAO
        } else {
            doctors1 = DoctorDAO.getAllDoctors();
        }
        req.setAttribute("doctors", doctors1);
        RequestDispatcher rd = req.getRequestDispatcher("doctorList.jsp");
        rd.forward(req, res);
    }
    
    
}
