<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hospital.User, com.hospital.UserDAO" %>
<%
    HttpSession session2 = request.getSession(false);
    if(session == null || session.getAttribute("userId") == null){
        response.sendRedirect("login.jsp");
        return;
    }
    int userId = (int) session.getAttribute("userId");
    User user = UserDAO.getUserById(userId);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background: #f2f2f2;
            color: #333;
        }

        .main-content {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .edit-box {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.2);
            width: 400px;
        }

        h2 {
            text-align: center;
            color: #006400;
            margin-bottom: 20px;
        }

        .form-group {
            margin: 15px 0;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
            color: #2E8B57;
        }

        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }

        .button-group {
            text-align: center;
            margin-top: 25px;
        }

        .button-group input {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            background-color: #006400;
            color: white;
            transition: 0.3s;
        }

        .button-group input:hover {
            background-color: #008000;
        }

        a.back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            text-decoration: none;
            color: #006400;
            font-weight: bold;
        }

        a.back-link:hover {
            color: #004d00;
        }
    </style>
</head>
<body>
    <div class="main-content">
        <div class="edit-box">
            <h2>Edit Profile</h2>
            <% if(user != null) { %>
            <form action="UpdateProfileServlet" method="post">
                <div class="form-group">
                    <label>Name:</label>
                    <input type="text" name="name" value="<%= user.getName() %>" required>
                </div>
                <div class="form-group">
                    <label>Email:</label>
                    <input type="email" name="email" value="<%= user.getEmail() %>" required>
                </div>
                <div class="form-group">
                    <label>Mobile:</label>
                    <input type="text" name="mobile" value="<%= user.getMobile() %>" required>
                </div>
                <div class="form-group">
                    <label>Hospital:</label>
                    <input type="text" name="hospital" value="<%= user.getHospital() %>" required>
                </div>
                <div class="button-group">
                    <input type="submit" value="Update Profile">
                </div>
            </form>
            <% } else { %>
                <p style="color:red; text-align:center;">User not found.</p>
            <% } %>
            <a class="back-link" href="UserProfileServlet">Back to Profile</a>
        </div>
    </div>
</body>
</html>
