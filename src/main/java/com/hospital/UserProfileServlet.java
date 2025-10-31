package com.hospital;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class UserProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = (int) session.getAttribute("userId");
        User user = UserDAO.getUserById(userId);

        if (user != null) {
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
            rd.forward(request, response);
        } else {
            response.sendRedirect("dashboard.jsp?msg=user_not_found");
        }
    }
}
