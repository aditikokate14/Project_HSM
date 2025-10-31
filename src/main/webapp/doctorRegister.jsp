<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Registration</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color:aqua;
    margin: 0;
    padding: 20px;
  }
  .container {
    max-width: 600px;
    margin: 40px auto;
    padding: 20px;
    background-color: white;
    border-radius: 8px;
    border: 3px solid black;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
  }
  h2 {
    text-align: center;
    color: black;
    margin-bottom: 20px;
  }
  table {
    width: 100%;
    border-collapse: separate;
    border-spacing: 10px;
  }
  td {
    padding: 8px;
    font-size: 16px;
  }
  label { font-weight: bold; }
  input, select {
    width: 100%;
    padding: 8px;
    border: 1px dashed black;
    border-radius: 4px;
    font-size: 15px;
  }
  
  button, a.button {
    background: #006400;
    color: white;
    border: none;
    padding: 8px 16px;
    border-radius: 5px;
    cursor: pointer;
    text-decoration: none;
     text-align: center;

}
  .center { text-align: center; margin-top: 20px; }
  input[type="submit"] {
    background-color: Green;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    cursor: pointer;
  }
  input[type="submit"]:hover { background-color: #45a049; }
</style>
</head>
<body>
  <div class="container">
    <h2>Doctor Registration</h2>
    <form action="DoctorRegisterServlet" method="post">
      <table>
        <tr>
          <td><label for="name">Name:</label></td>
          <td><input type="text" name="name" id="name" required></td>
        </tr>
        <tr>
          <td><label for="specialization">Specialization:</label></td>
          <td><input type="text" name="specialization" id="specialization" required></td>
        </tr>
        <tr>
          <td><label for="email">Email:</label></td>
          <td><input type="email" name="email" id="email" required></td>
        </tr>
        <tr>
          <td><label for="contact">Contact:</label></td>
          <td><input type="text" name="contact" id="contact" required></td>
        </tr>
        <tr>
          <td><label for="password">Password:</label></td>
          <td><input type="password" name="password" id="password" required></td>
        </tr>
      </table>

      <div class="center">
        <input type="submit" value="Register Doctor">
        <div class="center" style="margin-top: 20px; color:red;">
        <%
            String msg = (String) request.getAttribute("message");
            if (msg != null) out.print(msg);
        %>
        </div>
        <center>
    <a href="DashboardServlet" class="button">Dashboard</a>
    </center>
        <div class="center" style="margin-top: 15px;">
          Already registered? <a href="doctorLogin.jsp">Login here</a>
        </div>
      </div>
    </form>
  </div>
</body>
</html>
