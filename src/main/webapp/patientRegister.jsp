<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hospital Registration</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #87feee;
    margin: 0;
    padding: 5px;
    width: auto;
  }

  .container {
    max-width: 600px;
    margin: 20px auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border: 4px solid #333;
  }

  h1 {
    text-align: center;
    color: #333;
  }

  table {
    width: 100%;
    border-collapse: separate;
    border-spacing: 10px;
  }

  td {
    padding: 8px;
  }

  label {
    font-weight: bold;
  }

  input, select {
    padding: 8px;
    width: 100%;
    border: 1px dashed #333;
    border-radius: 4px;
    font-size: 16px;
  }

  button {
    padding: 10px 20px;
    background-color: #4caf50;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease;
  }

  button:hover {
    background-color: #45a049;
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

  .center {
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
  
   
    
    <h1>Patient Registration</h1>
	
    <form action="PatientRegisterServlet" method="post">
      <table>
        <tr>
          <td><label for="name">Name:</label></td>
          <td><input type="text" id="name" name="name" required></td>
        </tr>
        <tr>
          <td><label for="age">Age:</label></td>
          <td><input type="text" id="age" name="age" required></td>
        </tr>
        
        <tr>
          <td><label for="contact_no">Contact_no:</label></td>
          <td><input type="text" id="contact_no" name="contact_no" required></td>
        </tr>
        
        <tr>
          <td><label for="dob">DOB:</label></td>
          <td><input type="date" id="dob" name="dob" required></td>
        </tr>
        
        <tr>
          <td><label for="last_visit">Last_Visit</label></td>
          <td><input type="date" id="last_visit" name="last_visit" required></td>
        </tr>
        
        <tr>
          <td><label for="gender">Gender:</label></td>
          <td>
            <select id="gender" name="gender" required>
              <option value="">Select Gender</option>
              <option value="Male">Male</option>
              <option value="Female">Female</option>
              <option value="Other">Other</option>
            </select>
          </td>
        </tr>
        <tr>
          <td><label for="blood-group">Blood Group:</label></td>
          <td>
            <select id="blood_group" name="blood_group" required>
              <option value="">Select Blood Group</option>
              <option value="A+">A+</option>
              <option value="A-">A-</option>
              <option value="B+">B+</option>
              <option value="B-">B-</option>
              <option value="AB+">AB+</option>
              <option value="AB-">AB-</option>
              <option value="O+">O+</option>
              <option value="O-">O-</option>
            </select>
          </td>
        </tr>
        
        <tr>
          <td><label for="disease">Disease:</label></td>
          <td><input type="text" id="disease" name="disease" required></td>
        </tr>
        
        <tr>
          <td><label for="email">Email:</label></td>
          <td><input type="email" id="email" name="email" required></td>
        </tr>
        <tr>
          <td><label for="password">Password:</label></td>
          <td><input type="password" id="password" name="password" required></td>
        </tr>
        
      </table>
      <div class="center">
        <input type="submit" value="Register">
        <div class="center" style="margin-top: 20px; color:red;">
    </form>
	<center>
    <a href="DashboardServlet" class="button">Dashboard</a>
    </center>
    <div class="center" style="margin-top: 15px;">
      Already registered? <a href="patientLogin.jsp">Login here</a>
    </div>
     <%
        String msg = (String) request.getAttribute("message");
        if (msg != null) {
            out.print(msg);
        }
    %>
    
    
    
    
    
  </div>
</body>
</html>
