package com.hospital;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.http.*;



public class AppointmentListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	 String search = request.getParameter("search");
         List<Appointment> appointments;

         if (search != null && !search.trim().isEmpty()) {
             appointments = AppointmentDAO.searchAppointments(search);
         } else {
             appointments = AppointmentDAO.getAllAppointments();
         }


        request.setAttribute("appointments", appointments);

        RequestDispatcher rd = request.getRequestDispatcher("viewAppointments.jsp");
        rd.forward(request, response);
    }
}
