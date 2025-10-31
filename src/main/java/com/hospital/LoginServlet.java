package com.hospital;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?");
            pst.setString(1, email);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", rs.getString("name"));
                session.setAttribute("userId", rs.getInt("id")); // ✅ important!
                response.sendRedirect("DashboardServlet");
            } else {
                request.setAttribute("error", "Invalid email or password");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request, response);
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
