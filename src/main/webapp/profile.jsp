<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hospital.User" %>
<%
    User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Staff Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            background: #f9f9f9;
            color: #333;
        }

        .container {
            display: flex;
            height: 100vh;
        }

        .sidebar {
            width: 250px;
            background: #2E8B57;
            color: white;
            padding: 20px;
        }

        .sidebar a {
            color: white;
            text-decoration: none;
            display: block;
            margin: 10px 0;
            font-size: 16px;
        }

        .main-content {
            flex: 1;
            padding: 30px;
        }

        .profile-box {
            background: white;
            padding: 30px 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            margin: 40px auto;
        }

        h2 {
            color: #006400;
            margin-bottom: 10px;
            text-align: center;
        }

        p.subtitle {
            text-align: center;
            color: #555;
            margin-bottom: 30px;
        }

        .info-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin: 15px 0;
            padding-bottom: 8px;
            border-bottom: 1px solid #ddd;
        }

        .info-label {
            font-weight: bold;
            color: #2E8B57;
            width: 150px;
        }

        .info-value {
            flex: 1;
            text-align: right;
            color: #333;
        }

        .button-group {
            text-align: center;
            margin-top: 25px;
        }

        button {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 14px;
            margin: 5px;
        }

        #editProfile {
            background: #FFD700;
            color: #333;
        }

        #changePassword {
            background: #D3D3D3;
            color: #333;
        }

        footer {
            text-align: center;
            padding: 10px;
            background: #333;
            color: white;
            position: fixed;
            bottom: 0;
            width: 100%;
            font-size: 14px;
        }
    </style>
</head>
<body>

    <div class="main-content">
        <div class="profile-box">
            <h2>Staff Profile</h2>
            <p class="subtitle">Manage your profile information</p>

            <% if (user != null) { %>
                <div class="info-row">
                    <div class="info-label">Name:</div>
                    <div class="info-value"><%= user.getName() %></div>
                </div>
                <div class="info-row">
                    <div class="info-label">Email:</div>
                    <div class="info-value"><%= user.getEmail() %></div>
                </div>
                <div class="info-row">
                    <div class="info-label">Mobile:</div>
                    <div class="info-value"><%= user.getMobile()%></div>
                </div>
                <div class="info-row">
                    <div class="info-label">Hospital:</div>
                    <div class="info-value"><%= user.getHospital() %></div>
                </div>
            <% } else { %>
                <p style="color:red; text-align:center;">User details not found.</p>
            <% } %>

            <div class="button-group">
    		<a href="editProfile.jsp" style="text-decoration:none;">
        	<button id="editProfile">Edit Profile</button>
    		</a>
    		<a href="changePassword.jsp" style="text-decoration:none;">
    		<button id="changePassword">Change Password</button>
    		</a>
			</div>

        </div>
    </div>

    <footer>
        &copy; 2025 Clinic Portal. All Rights Reserved.
    </footer>

</body>
</html>
