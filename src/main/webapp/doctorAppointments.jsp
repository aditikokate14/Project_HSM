<%@ page import="java.util.*" %>
<%@ page import="com.hospital.Appointment" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Appointments</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f2f8ff;
    margin: 0;
    padding: 20px;
}
h2 {
    text-align: center;
    color: #007bff;
}
table {
    width: 90%;
    margin: 20px auto;
    border-collapse: collapse;
    background-color: white;
}
th, td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: center;
}
th {
    background-color: #007bff;
    color: white;
}
tr:nth-child(even) {
    background-color: #f9f9f9;
}
a.back {
    display: block;
    width: 150px;
    margin: 20px auto;
    text-align: center;
    padding: 10px;
    background-color: #28a745;
    color: white;
    text-decoration: none;
    border-radius: 5px;
}
a.back:hover {
    background-color: #218838;
}
</style>
</head>
<body>

<h2>Appointments for  <%= request.getAttribute("doctorName") %></h2>

<table>
<tr>
    <th>Appointment ID</th>
    <th>Patient Name</th>
    <th>Date</th>
    <th>Day</th>
    <th>Time</th>
</tr>

<%
List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
if (appointments != null && !appointments.isEmpty()) {
    for (Appointment a : appointments) {
%>
<tr>
    <td><%= a.getAppointmentId() %></td>
    <td><%= a.getPatientname() %></td>
    <td><%= a.getAppointmentDate() %></td>
    <td><%= a.getDay() %></td>
    <td><%= a.getAppointmentTime() %></td>
</tr>
<%
    }
} else {
%>
<tr><td colspan="5">No appointments found for this doctor.</td></tr>
<% } %>
</table>

<a href="DashboardServlet" class="back">Back to Dashboard</a>

</body>
</html>

