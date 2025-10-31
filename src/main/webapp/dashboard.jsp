<%@ page import="java.util.*" %>
<%@ page import="com.hospital.Appointment" %>
<%@ page import="com.hospital.Doctor" %>
<%@ page import="com.hospital.Patient" %>
<%@ page import="jakarta.servlet.http.*" %>
<%@ page session="true" %>

<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    List<Appointment> appointments = (List<Appointment>) request.getAttribute("appointments");
    List<Doctor> doctors = (List<Doctor>) request.getAttribute("doctors");
    List<Patient> patients = (List<Patient>) request.getAttribute("patients");

    int doctorCount = (request.getAttribute("doctorCount") != null)
        ? (Integer) request.getAttribute("doctorCount") : 0;
    int patientCount = (request.getAttribute("patientCount") != null)
        ? (Integer) request.getAttribute("patientCount") : 0;
    int appointmentCount = (request.getAttribute("appointmentCount") != null)
        ? (Integer) request.getAttribute("appointmentCount") : 0;
%>

<!DOCTYPE html>
<html>
<head>
<title>Clinic Portal - Dashboard</title>
<style>
body {
    font-family: Arial, sans-serif;
    margin:0;
    background:white;
}
.sidebar {
    width:200px; height:120vh; background:green; color:white;
    float:left; padding:20px;
}
.sidebar a {
    color:white; text-decoration:none; display:block; padding:10px;
}
.sidebar .submenu { display:none; padding-left:20px; }
.sidebar .has-submenu:hover .submenu { display:block; }

.main { margin-left:220px; padding:20px; }
.dashboard-cards {
    display:flex; gap:30px; flex-wrap:wrap; margin-top:30px;
}
.card {
    padding:20px; border-radius:10px; flex:1; min-width:200px; text-align:center;
    color:white; font-weight:bold; cursor:pointer; transition:0.3s;
}
.card:hover { transform: scale(1.05); }
.doctor { background:purple; }
.patient { background:#007bff; }
.appointment { background:#ffc107; color:black; }

table {
    width:95%; margin:auto; margin-top:40px; border-collapse:collapse; background:white;
}
th, td {
    border:1px solid #ccc; padding:10px; text-align:center; background-color: white;
}
th { background: green; color:white; }
tr:nth-child(even) { background:#f2f2f2; }

.hidden { display: none; }

.chart-container {
    max-width: 600px;
    margin: 30px auto;
    background: white;
    padding: 20px;
    border-radius: 10px;
    border: 2px solid #000;
}
</style>

<!-- ✅ Add Chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>

<div class="sidebar">
    <h3>Clinic Portal</h3>
    <a href="DashboardServlet">Dashboard</a>

    <div class="has-submenu">
        <a href="#">Doctors &#9662;</a>
        <div class="submenu">
            <a href="doctorRegister.jsp">Add Doctor</a>
            <a href="DoctorServlet">Doctor List</a>
        </div>
    </div>

    <div class="has-submenu">
        <a href="#">Patients &#9662;</a>
        <div class="submenu">
            <a href="patientRegister.jsp">Add Patient</a>
            <a href="PatientServlet">Patient List</a>
        </div>
    </div>

    <div class="has-submenu">
        <a href="#">Appointments &#9662;</a>
        <div class="submenu">
            <a href="patientLogin.jsp">Add Appointment</a>
            <a href="AppointmentListServlet">Appointment List</a>
        </div>
    </div>

    <a href="UserProfileServlet">Profile</a>
    <a href="logout.jsp" style="color:red; font-weight:bold;">Logout</a>
</div>

<div class="main">
    <h1>Welcome, <%= username %></h1>
    
    <div class="dashboard-cards">
        <div class="card doctor" onclick="showSection('doctorList')">
            <h2><%= doctorCount %></h2>
            <p>Doctors</p>
        </div>
        <div class="card patient" onclick="showSection('patientList')">
            <h2><%= patientCount %></h2>
            <p>Patients</p>
        </div>
        <div class="card appointment" onclick="showSection('appointmentList')">
            <h2><%= appointmentCount %></h2>
            <p>Appointments</p>
        </div>
    </div>

    
    <div id="doctorList" class="hidden">
        <h2 style="margin-top:40px; text-align:center;">All Doctors</h2>
        <table>
            <tr><th>ID</th><th>Name</th><th>Specialization</th><th>Email</th><th>Contact</th></tr>
            <%
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
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="5">No doctors found</td></tr>
            <% } %>
        </table>
    </div>

    <div id="patientList" class="hidden">
        <h2 style="margin-top:40px; text-align:center;">All Patients</h2>
        <table>
            <tr><th>ID</th><th>Name</th><th>Age</th><th>Gender</th><th>Disease</th><th>Email</th><th>Contact</th></tr>
            <%
                if (patients != null && !patients.isEmpty()) {
                    for (Patient p : patients) {
            %>
            <tr>
                <td><%= p.getPatientId() %></td>
                <td><%= p.getName() %></td>
                <td><%= p.getAge() %></td>
                <td><%= p.getGender() %></td>
                <td><%= p.getDisease() %></td>
                <td><%= p.getEmail() %></td>
                <td><%= p.getContact()%></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="7">No patients found</td></tr>
            <% } %>
        </table>
    </div>

    <div id="appointmentList" class="hidden">
        <h2 style="margin-top:40px; text-align:center;">All Appointments</h2>
        <table>
            <tr><th>ID</th><th>Patient Name</th><th>Doctor Name</th><th>Date</th><th>Day</th><th>Time</th></tr>
            <%
                if (appointments != null && !appointments.isEmpty()) {
                    for (Appointment a : appointments) {
            %>
            <tr>
                <td><%= a.getAppointmentId() %></td>
                <td><%= a.getPatientname() %></td>
                <td><%= a.getDoctorname() %></td>
                <td><%= a.getAppointmentDate() %></td>
                <td><%= a.getDay() %></td>
                <td><%= a.getAppointmentTime() %></td>
            </tr>
            <%
                    }
                } else {
            %>
            <tr><td colspan="6">No appointments found</td></tr>
            <% } %>
        </table>
    </div>
    <!-- ✅ Chart Section -->
    <div class="chart-container">
        <h2 style="text-align:center;">Clinic Overview</h2>
        <canvas id="clinicChart"></canvas>
    </div>
    
</div>

<script>
function showSection(id) {
    ["doctorList", "patientList", "appointmentList"].forEach(sec => {
        document.getElementById(sec).classList.add("hidden");
    });
    document.getElementById(id).classList.remove("hidden");
}

// ✅ Chart.js bar graph
const ctx = document.getElementById('clinicChart');
new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Doctors', 'Patients', 'Appointments'],
        datasets: [{
            label: 'Count',
            data: [<%= doctorCount %>, <%= patientCount %>, <%= appointmentCount %>],
            backgroundColor: ['#800080', '#007bff', '#ffc107']
        }]
    },
    options: {
        responsive: true,
        plugins: {
            legend: { display: false },
            title: { display: true, text: 'Clinic Overview Statistics' }
        },
        scales: {
            y: { 
                beginAtZero: true,
                ticks: {
                    stepSize: 5,           // Show Y-axis ticks at 0, 5, 10, 15...
                    precision: 0,          // Avoid floating points
                    callback: function(value) {
                        if (Number.isInteger(value)) {
                            return value;  // Show only integer labels
                        }
                    }
                }
            }
        }

    }
});
</script>
</body>
</html>
