<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
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
<form action="LoginServlet" method="post">
  <h2>User Login</h2>
  <input type="email" name="email" placeholder="Enter Email" required><br>
  <input type="password" name="password" placeholder="Enter Password" required><br>
  <input type="submit" value="Login">
  <p>New user? <a href="Resistration.jsp">Register here</a></p>
  <p style="color:red;">
    <%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
  </p>
</form>
</body>
</html>
