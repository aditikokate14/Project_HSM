<%@page import="java.util.List"%>
<%@page import="com.hospital.DoctorDAO"%>
<%@page import="com.hospital.Doctor"%>
<%@ page session="true" %>
<%
    // Ensure patient is logged in
    Integer patientId = (Integer) session.getAttribute("patientId");
    String patientName = (String) session.getAttribute("patientName");
    if(patientId == null || patientName == null){
        response.sendRedirect("patientLogin.jsp");
        return;
    }

    List<Doctor> doctors = DoctorDAO.getAllDoctors();
%>
<!DOCTYPE html>
<html>
<head>
<title>Book Appointment</title>
<style>
body { font-family: Arial; background-color: lightblue; margin: 0; padding: 20px; }
.container { max-width: 600px; margin: auto; background: white; padding: 20px; border-radius: 10px; border: 3px solid black; }
h2 { text-align: center; color: blue; }
table { width: 100%; border-collapse: separate; border-spacing: 10px; }
td { padding: 8px; }
label { font-weight: bold; }
input, select { padding: 8px; width: 100%; border: 1px solid gray; border-radius: 4px; }
input[type="submit"] { background-color: blue; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer; }
input[type="submit"]:hover { background-color: darkblue; }
.msg { color: green; text-align: center; font-weight: bold; }
a { display: block; margin-top: 20px; text-align: center; text-decoration: none; color: blue; }
a:hover { color: darkblue; }
</style>
</head>
<body>
<div class="container">
  <h2>Book Appointment</h2>

  <form action="BookAppointmentServlet" method="post">
    <table>
      <tr>
        <td><label>Doctor:</label></td>
        <td>
          <select name="doctorId" required>
    <option value="">Select Doctor</option>
    <% for (Doctor d : doctors) { %>
        <option value="<%= d.getDoctorId() %>">
            <%= d.getName() %> - <%= d.getSpecialization() %>
        </option>
    <% } %>
</select>

        </td>
      </tr>
      <tr>
        <td><label>Date:</label></td>
        <td><input type="date" name="date" id="date" required></td>
      </tr>
      <tr>
        <td><label>Day:</label></td>
        <td><input type="text" name="day" id="day" readonly required></td>
      </tr>
      <tr>
        <td><label>Time:</label></td>
        <td><input type="time" name="time" required></td>
      </tr>
      <tr>
        <td colspan="2" style="text-align:center;">
          <input type="submit" value="Book Appointment">
        </td>
      </tr>
    </table>
  </form>

  <a href="DashboardServlet">Back to Dashboard</a>

  <% if (request.getParameter("msg") != null) { %>
      <p class="msg"><%= request.getParameter("msg") %></p>
  <% } %>
</div>

<script>
// ✅ Auto-fill the "Day" field when user selects a date
document.getElementById("date").addEventListener("change", function() {
    const dateValue = new Date(this.value);
    const options = { weekday: 'long' };
    if (!isNaN(dateValue)) {
        document.getElementById("day").value = dateValue.toLocaleDateString('en-US', options);
    } else {
        document.getElementById("day").value = "";
    }
});
</script>
</body>
</html>
