<!DOCTYPE html>
<html>
<head>
  <title>Clinic Portal</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      display: flex;
      height: 100vh;
      margin: 0;
    }

    .left {
      flex: 1;
      background: #2e8b57;
      color: white;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
    }

    .left h1 {
      font-size: 2.5em;
    }

    .left p {
      margin: 20px 0;
      font-size: 1.2em;
      text-align: center;
    }

    .buttons a {
      text-decoration: none;
      margin: 0 10px;
      padding: 10px 20px;
      font-size: 1em;
      border-radius: 5px;
      transition: background-color 0.3s ease, color 0.3s ease;
      display: inline-block;
      text-align: center;
      cursor: pointer;
    }

    .login-link {
      background-color: white;
      color: #2e8b57;
    }

    .login-link:hover {
      background-color: #ccc;
    }

    .register-link {
      background-color: transparent;
      border: 2px solid white;
      color: white;
    }

    .register-link:hover {
      background-color: white;
      color: #2e8b57;
    }

    .right {
      flex: 1;
      display: flex;
      justify-content: center;
      align-items: center;
      overflow: hidden;
    }

    .right img {
      width: 100%;
      height: 100%;
      object-fit: cover; /* image fills div completely */
    }
  </style>
</head>
<body>
  <div class="left">
    <h1>Welcome to Hospital</h1>
    <p>Manage staff, doctors, and appointments all in one secure system.</p>
    <div class="buttons">
      <a href="login.jsp" class="login-link">Login</a>
      <a href="Resistration.jsp" class="register-link">Register</a>
    </div>
  </div>
  <div class="right"> 
    <img src="Image/Hospital.jpg" alt="Clinic Logo">
  </div>
</body>
</html>
