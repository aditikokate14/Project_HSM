<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    HttpSession session2 = request.getSession(false);
    if(session == null || session.getAttribute("userId") == null){
        response.sendRedirect("login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Change Password</title>
    <style>
        body { font-family: Arial; background: #f2f2f2; margin: 0; }
        .main-content { display:flex; justify-content:center; align-items:center; height:100vh; }
        .change-box { background:white; padding:40px; border-radius:10px; box-shadow:0 0 15px rgba(0,0,0,0.2); width:400px; }
        h2 { text-align:center; color:#006400; margin-bottom:20px; }
        .form-group { margin:15px 0; }
        .form-group label { display:block; font-weight:bold; margin-bottom:5px; color:#2E8B57; }
        .form-group input { width:100%; padding:10px; border:1px solid #ccc; border-radius:5px; }
        .button-group { text-align:center; margin-top:25px; }
        .button-group input { padding:10px 20px; border:none; border-radius:5px; cursor:pointer; background-color:#006400; color:white; font-weight:bold; }
        .button-group input:hover { background-color:#008000; }
        .message { text-align:center; margin-top:15px; font-weight:bold; }
    </style>
</head>
<body>
    <div class="main-content">
        <div class="change-box">
            <h2>Change Password</h2>
            <form action="<%=request.getContextPath()%>/ChangePasswordServlet" method="post">
                <div class="form-group">
                    <label>Current Password:</label>
                    <input type="password" name="currentPassword" required>
                </div>
                <div class="form-group">
                    <label>New Password:</label>
                    <input type="password" name="newPassword" required>
                </div>
                <div class="form-group">
                    <label>Confirm New Password:</label>
                    <input type="password" name="confirmPassword" required>
                </div>
                <div class="button-group">
                    <input type="submit" value="Update Password">
                </div>
            </form>
            <% if(request.getAttribute("msg") != null) { %>
                <div class="message" style="color:<%=request.getAttribute("color")%>;">
                    <%= request.getAttribute("msg") %>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>
