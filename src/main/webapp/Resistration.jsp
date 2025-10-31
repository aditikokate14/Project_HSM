<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
<style>
body {
  font-family: Arial, sans-serif;
  background-color: #e6f2ff;
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
form {
  background: white;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px gray;
  text-align: center;
}
input {
  margin: 8px;
  padding: 10px;
  width: 90%;
}
input[type="submit"] {
  background-color: #0066cc;
  color: white;
  border: none;
  cursor: pointer;
  width: 100%;
}
a {
  color: #0066cc;
  text-decoration: none;
}
</style>
</head>
<body>
<form action="RegistrationServlet" method="post">
  <h2>User Registration</h2>
  <input type="text" name="name" placeholder="Enter Name" required><br>
  <input type="email" name="email" placeholder="Enter Email" required><br>
   <input type="text" name="mobile" placeholder="Enter mobile_no" required><br>
  <input type="password" name="password" placeholder="Enter Password" required><br>
   <input type="text" name="hospital_name" placeholder="Enter hospital_name" required><br>
  <input type="submit" value="Register">
  <% String error = (String) request.getAttribute("errorMessage"); %>
<% if (error != null) { %>
    <p style="color:red; text-align:center;"><%= error %></p>
<% } %>
  
  <p>Already registered? <a href="login.jsp">Login here</a></p>
</form>
</body>
</html>
