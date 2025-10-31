<%@ page import="java.util.*,com.hospital.Appointment" %>
<%
    List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Appointments</title>
    <style>
        body { font-family: Arial; background: #eef; padding: 30px; }
        h2 { text-align: center; color: #333; }
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
        
        table { width: 100%; border-collapse: collapse; background: #fff; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
        th { background: #007bff; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        a { color: red; text-decoration: none; font-weight: bold; }
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
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>

<div class="top-bar">
    <form action="AppointmentListServlet" method="get">
        <input type="text" name="search" placeholder="Search by name or disease">
        <button type="submit">Search</button>
    </form>
</div>
</center>
	
    <h2>All Appointments</h2>
    <table>
        <tr>
            <th>ID</th>
            
            <th>Patient Name</th>
            <th>Doctor Name</th>
            <th>Date</th>
            <th>Day</th>
            <th>Time</th>
            <th>Action</th>
        </tr>
        <%
            if (appointments != null && !appointments.isEmpty()) {
                for (Appointment a : appointments) {
        %>
        <tr>
            <td><%= a.getAppointmentId() %></td>
            
            <td><%= a.getPatientname() %></td>
            <td><%= a.getDoctorname() %></td>
            <td><%= a.getAppointmentDate() %></td>
            <td><%=a.getDay() %>
            <td><%= a.getAppointmentTime() %></td>
            <td>
                <a href="DeleteAppointmentServlet?appointmentId=<%= a.getAppointmentId() %>" 
                   onclick="return confirm('Are you sure you want to cancel this appointment?');">
                   Cancel
                </a>
            </td>
        </tr>
        <% 
                }
            } else { 
        %>
        <tr><td colspan="8">No appointments found</td></tr>
        <% } %>
    </table>
    
    <div class="center">
    <a href="DashboardServlet">Back to Dashboard</a>
</div>
</body>
</html>
