<%@page import="com.hospital.Patient"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>Patient Management</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f7ff;
    margin: 0;
    padding: 0;
}

/* 🟦 Top Bar */
.top-bar {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: #e6f0ff;
    padding: 15px 40px;
    border-bottom: 2px solid #007bff;
}

.top-bar input[type="text"] {
    padding: 8px 12px;
    width: 280px;
    border: 1px solid #007bff;
    border-radius: 20px;
    outline: none;
    font-size: 14px;
}

.top-bar button {
    margin-left: 10px;
    padding: 8px 16px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 20px;
    cursor: pointer;
    font-weight: bold;
}

.top-bar button:hover {
    background-color: #0056b3;
}

/* 🧾 Table Design */
h2 {
    text-align: center;
    color: #003366;
    margin-top: 25px;
}

table {
    width: 90%;
    margin: 20px auto;
    border-collapse: collapse;
    background-color: white;
    box-shadow: 0 0 8px rgba(0,0,0,0.1);
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
    background-color: #f2f6ff;
}

tr:hover {
    background-color: #e8f0ff;
}

/* 🎯 Action Buttons */
.action-btn {
    display: inline-block;
    padding: 6px 12px;
    margin: 3px;
    border: none;
    border-radius: 5px;
    color: white;
    cursor: pointer;
    font-weight: bold;
}

.edit-btn {
    background-color: #28a745;
}
.edit-btn:hover {
    background-color: #218838;
}

.delete-btn {
    background-color: #dc3545;
    text-decoration: none;
    padding: 6px 12px;
    border-radius: 5px;
    color: white;
    font-weight: bold;
}
.delete-btn:hover {
    background-color: #c82333;
}

/* 🏠 Dashboard Link */
.center {
    text-align: center;
    margin: 20px;
}
.center a {
    background-color: #007bff;
    color: white;
    padding: 8px 15px;
    border-radius: 20px;
    text-decoration: none;
    font-weight: bold;
}
.center a:hover {
    background-color: #0056b3;
}
</style>
</head>
<body>

<!-- 🔍 Search Bar -->
<div class="top-bar">
    <form action="PatientServlet" method="get">
        <input type="text" name="search" placeholder="Search by name or disease">
        <button type="submit">Search</button>
    </form>
</div>

<h2>Patient List</h2>

<!-- 📋 Table -->
<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Age</th>
<th>Gender</th>
<th>Blood Group</th>
<th>Disease</th>
<th>Email</th>
<th>Contact</th>
<th>DOB</th>
<th>Last Visit</th>
<th>Action</th>
</tr>

<%
List<Patient> patients = (List<Patient>) request.getAttribute("patients");
if (patients != null && !patients.isEmpty()) {
    for (Patient p : patients) {
%>
<tr>
<td><%=p.getPatientId()%></td>
<td><%=p.getName()%></td>
<td><%=p.getAge()%></td>
<td><%=p.getGender()%></td>
<td><%=p.getBloodGroup()%></td>
<td><%=p.getDisease()%></td>
<td><%=p.getEmail()%></td>
<td><%=p.getContact()%></td>
<td><%=p.getDob()%></td>
<td><%=p.getLastVisit()%></td>
<td>
    <form action="EditPatientServlet" method="get" style="display:inline;">
        <input type="hidden" name="patientId" value="<%= p.getPatientId() %>">
        <button type="submit" class="action-btn edit-btn">Edit</button>
    </form>
    <form action="DeletePatientServlet" method="post" style="display:inline;" 
          onsubmit="return confirm('Are you sure you want to delete this patient?');">
        <input type="hidden" name="patient_id" value="<%= p.getPatientId() %>">
        <button type="submit" class="action-btn delete-btn">Delete</button>
    </form>
</td>
</tr>
<%
    }
} else {
%>
<tr><td colspan="11">No patients found</td></tr>
<% } %>
</table>

<!-- 🔙 Dashboard -->
<div class="center">
    <a href="DashboardServlet">Back to Dashboard</a>
</div>

</body>
</html>
