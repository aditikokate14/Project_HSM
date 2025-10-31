package com.hospital;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class UpdateProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if(session == null || session.getAttribute("userId") == null){
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String hospital = request.getParameter("hospital");

        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE users SET name=?, email=?, mobile=?, hospital_name=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, mobile);
            ps.setString(4, hospital);
            ps.setInt(5, userId);
            ps.executeUpdate();
            ps.close();
            con.close();
            response.sendRedirect("UserProfileServlet");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
