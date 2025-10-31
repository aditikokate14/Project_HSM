<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doctor Login</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f2f8ff;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
form {
    background-color: #fff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    width: 350px;
}
h2 {
    text-align: center;
    color: #007bff;
}
input[type="text"], input[type="password"] {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 5px;
}
button {
    width: 100%;
    padding: 10px;
    background-color: #007bff;
    border: none;
    color: white;
    border-radius: 5px;
    cursor: pointer;
}
button:hover {
    background-color: #0056b3;
}
p {
    text-align: center;
    color: red;
}
</style>
</head>
<body>

<form action="DoctorLoginServlet" method="post">
    <h2>Doctor Login</h2>
    <input type="text" name="email" placeholder="Enter Email" required>
    <input type="password" name="password" placeholder="Enter Password" required>
    <button type="submit">Login</button>

    <%
        String msg = request.getParameter("msg");
        if (msg != null) {
    %>
        <p><%= msg %></p>
    <%
        }
    %>
</form>

</body>
</html>
