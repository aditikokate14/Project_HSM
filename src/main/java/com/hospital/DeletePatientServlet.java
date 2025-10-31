package com.hospital;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class DeletePatientServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String patientId = request.getParameter("patient_id");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM patients WHERE patient_id=?");
            ps.setString(1, patientId);
            int rows = ps.executeUpdate();
            con.close();

            if (rows > 0) {
                // Redirect to patient list after successful delete
                response.sendRedirect(request.getContextPath() + "/PatientServlet");
            } else {
                response.getWriter().println("<h3 style='color:red;'>Patient not found or could not delete.</h3>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<h3 style='color:red;'>Failed to delete patient.</h3>");
        }
    }
}
