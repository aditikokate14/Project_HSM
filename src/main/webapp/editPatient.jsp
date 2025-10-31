<%@ page import="com.hospital.Patient" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Patient</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #eaf6ff;
    margin: 0;
    padding: 20px;
  }

  .container {
    max-width: 600px;
    margin: auto;
    background: white;
    padding: 20px;
    border-radius: 10px;
    border: 3px solid black;
  }

  h2 {
    text-align: center;
    color:blue;
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
    border: 1px solid #ccc;
    border-radius: 4px;
  }

  button {
    background-color: #007bff;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
  }

  button:hover {
    background-color: #0056b3;
  }
</style>
</head>
<body>
  <div class="container">
    <h2>Patient Details</h2>

    <%
      Patient p = (Patient) request.getAttribute("patient");
      if (p != null) {
    %>
    <form action="UpdatePatientServlet" method="post">
    <input type="hidden" name="patient_id" value="<%= p.getPatientId() %>">
      <table>
      <table>
        <tr>
          <td><label for="name">Name:</label></td>
          <td><input type="text" id="name" name="name" value="<%=p.getName()%>" required></td>
        </tr>
        <tr>
          <td><label for="age">Age:</label></td>
          <td><input type="text" id="age" name="age" value="<%=p.getAge()%>" required></td>
        </tr>
        <tr>
          <td><label for="gender">Gender:</label></td>
          <td>
            <select id="gender" name="gender" required>
              <option value="Male" <%= p.getGender().equals("Male") ? "selected" : "" %>>Male</option>
              <option value="Female" <%= p.getGender().equals("Female") ? "selected" : "" %>>Female</option>
              <option value="Other" <%= p.getGender().equals("Other") ? "selected" : "" %>>Other</option>
            </select>
          </td>
        </tr>
        <tr>
          <td><label for="blood_group">Blood Group:</label></td>
          <td>
            <select id="blood_group" name="blood_group" required>
              <%
                String[] groups = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
                for (String g : groups) {
              %>
                <option value="<%=g%>" <%= p.getBloodGroup().equals(g) ? "selected" : "" %>><%=g%></option>
              <% } %>
            </select>
          </td>
        </tr>
        <tr>
          <td><label for="disease">Disease:</label></td>
          <td><input type="text" id="disease" name="disease" value="<%=p.getDisease()%>" required></td>
        </tr>
        <tr>
          <td><label for="email">Email:</label></td>
          <td><input type="email" id="email" name="email" value="<%=p.getEmail()%>" required></td>
        </tr>
        <tr>
          <td><label for="contact_no">Contact:</label></td>
          <td><input type="text" id="contact_no" name="contact_no" value="<%=p.getContact()%>" required></td>
        </tr>
        <tr>
          <td><label for="dob">DOB:</label></td>
          <td><input type="date" id="dob" name="dob" value="<%=p.getDob()%>" required></td>
        </tr>
        <tr>
          <td><label for="last_visit">Last Visit:</label></td>
          <td><input type="date" id="last_visit" name="last_visit" value="<%=p.getLastVisit()%>" required></td>
        </tr>
        <tr>
          <td colspan="2" style="text-align:center;">
            <button type="submit">Save</button>
          </td>
        </tr>
      </table>
    </form>
    <%
      } else {
    %>
      <p style="text-align:center; color:red;">No patient data available to edit.</p>
    <%
      }
    %>
  </div>
</body>
</html>
