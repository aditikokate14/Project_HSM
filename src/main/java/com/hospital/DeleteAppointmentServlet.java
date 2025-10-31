package com.hospital;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class DeleteAppointmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("appointmentId");
        if (idStr != null) {
            int appointmentId = Integer.parseInt(idStr);
            boolean deleted = AppointmentDAO.deleteAppointment(appointmentId);

            if (deleted) {
                response.sendRedirect("AppointmentListServlet?msg=Appointment+Cancelled+Successfully");
            } else {
                response.sendRedirect("AppointmentListServlet?msg=Failed+to+Cancel+Appointment");
            }
        } else {
            response.sendRedirect("AppointmentListServlet?msg=Invalid+Appointment+ID");
        }
    }
}
