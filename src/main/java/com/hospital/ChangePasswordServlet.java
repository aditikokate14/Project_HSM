package com.hospital;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ChangePasswordServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("msg", "New password and confirm password do not match!");
            request.setAttribute("color", "red");
            RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
            rd.forward(request, response);
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            // Check current password
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE id=? AND password=?");
            ps.setInt(1, userId);
            ps.setString(2, currentPassword);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Update password
                PreparedStatement psUpdate = con.prepareStatement(
                    "UPDATE users SET password=? WHERE id=?");
                psUpdate.setString(1, newPassword);
                psUpdate.setInt(2, userId);

                int updated = psUpdate.executeUpdate();
                if (updated > 0) {
                    request.setAttribute("msg", "Password updated successfully!");
                    request.setAttribute("color", "green");
                } else {
                    request.setAttribute("msg", "Failed to update password.");
                    request.setAttribute("color", "red");
                }

                psUpdate.close();
            } else {
                request.setAttribute("msg", "Current password is incorrect!");
                request.setAttribute("color", "red");
            }

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "Error occurred. Try again.");
            request.setAttribute("color", "red");
        }

        RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
        rd.forward(request, response);
    }
}
