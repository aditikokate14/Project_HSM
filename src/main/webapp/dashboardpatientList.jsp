<%@ page import="java.util.*" %>
<%@ page import="com.hospital.Patient" %>

<%
    List<Patient> patients = (List<Patient>) request.getAttribute("patients");
%>

<table border="1" cellspacing="0" cellpadding="8" style="width:90%; margin:auto; border-collapse:collapse; background:#fff;">
    <tr style="background:#006400; color:white;">
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>DOB</th>
        <th>Gender</th>
        <th>Blood Group</th>
        <th>Disease</th>
        <th>Email</th>
        <th>Contact</th>
        <th>Last Visit</th>
    </tr>

    <%
        if (patients != null && !patients.isEmpty()) {
            for (Patient p : patients) {
    %>
    <tr>
        <td><%= p.getPatientId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getAge() %></td>
        <td><%= p.getDob() %></td>
        <td><%= p.getGender() %></td>
        <td><%= p.getBloodGroup() %></td>
        <td><%= p.getDisease() %></td>
        <td><%= p.getEmail() %></td>
        <td><%= p.getContact() %></td>
        <td><%= p.getLastVisit() %></td>
    </tr>
    <%
            }
        } else {
    %>
    <tr>
        <td colspan="10" style="text-align:center; color:red;">No patients found</td>
    </tr>
    <%
        }
    %>
</table>
