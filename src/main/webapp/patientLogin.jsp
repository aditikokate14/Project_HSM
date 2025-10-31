<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Login</title>
<style>
body { font-family: Arial; background: #f0f2f5; }
form {
  background: white; padding: 20px; border-radius: 10px;
  width: 300px; margin: 50px auto; box-shadow: 0 0 10px #ccc;
}
input { width: 100%; margin: 5px 0; padding: 8px; }
button { background: #4CAF50; color: white; padding: 8px; border: none; width: 100%; border-radius: 5px; }
</style>
</head>
<body>
<form action="PatientLoginServlet" method="post">
  <h2>Patient Login</h2>
  Email: <input type="text" name="email" required><br>
  Password: <input type="password" name="password" required><br>
  <button type="submit">Login</button>
  <%
    String msg = request.getParameter("msg");
    if ("invalid".equals(msg)) {
  %>
    <p style="color:red;">Invalid email or password!</p>
  <%
    }
  %>
</form>
</body>
</html>
