<%@page import="com.hospital.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Doctor List</title>

<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f6f9;
    margin: 0;
    padding: 0;
}

h1 {
    text-align: center;
    color: #004080;
}

.container {
    width: 90%;
    margin: 20px auto;
    background: white;
    border-radius: 10px;
    padding: 20px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
}

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
    width: 300px;
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
      
}

button, a.button {
    background: #006400;
    color: white;
    border: none;
    padding: 8px 16px;
    border-radius: 5px;
    cursor: pointer;
    text-decoration: none;
}

button:hover, a.button:hover {
    background: #004d00;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 15px;
}

th, td {
    border: 1px solid #ccc;
    padding: 10px;
    text-align: center;
}

th {
    background: #007bff;
    color: white;
}

tr:nth-child(even) {
    background: #f9f9f9;
}

a.delete-link {
    color: red;
    text-decoration: none;
}

a.delete-link:hover {
    text-decoration: underline;
}
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

</style>
</head>
<body>
<div class="top-bar">
        <form action="DoctorServlet" method="get">
            <input type="text" name="search" placeholder="Search by name or specialization">
            <button type="submit">Search</button>
        </form>
        
    </div>
<div class="container">
    <h1>Doctor List</h1>

    <!-- 🔍 Search and Back to Dashboard -->
    

    <!-- 🩺 Doctor Table -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Specialization</th>
                <th>Email</th>
                <th>Contact</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <%
        List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctors");
        if (doctors != null && !doctors.isEmpty()) {
            for (Doctor d : doctors) {
        %>
            <tr>
                <td><%= d.getDoctorId() %></td>
                <td>
    				<form action="DoctorAppointmentServlet" method="get" style="margin:0;">
       				<input type="hidden" name="doctorId" value="<%= d.getDoctorId() %>">
        		<button type="submit" 
           			 style="background-color:white; color:black; border:none; padding:6px 12px; border-radius:5px; cursor:pointer;">
           				 <%= d.getName() %>
       				 </button>
   					 </form>
						</td>

                <td><%= d.getSpecialization() %></td>
                <td><%= d.getEmail() %></td>
                <td><%= d.getContact()%></td>
                <td>
                    <a class="delete-link" href="DeleteDoctorServlet?doctor_id=<%= d.getDoctorId() %>"
                       onclick="return confirm('Are you sure you want to delete this doctor?');">Delete</a>
                </td>
            </tr>
        <%
            }
        } else {
        %>
            <tr><td colspan="6">No doctors found</td></tr>
        <%
        }
        %>
        </tbody>
    </table>
</div>
<div class="center">
    <a href="DashboardServlet">Back to Dashboard</a>
</div>

</body>
</html>
