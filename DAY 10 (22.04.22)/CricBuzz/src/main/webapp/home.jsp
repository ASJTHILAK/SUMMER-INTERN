<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>IPL</title> 
<style>
form {
box-sizing : content-box; 
border: 5px solid black;
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  border: 5px solid black;
}

li {
  float: left;
  border-right:1px solid #bbb;
}	

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 12px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: black;
}

input[type=text], input[type=password] {
  width: 50%;
  padding: 12px 20px;
  margin: 16px 16px;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #333;
  color: white;
  padding: 12px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 50%;
}

button:hover:not(.active) {
  background-color: black;
}


span.psw {
  float: center;
  padding-top: 16px;
}

@media screen and (max-width: 100px) {
  span.psw {
     display: block;
     float: none;
  }
}
footer{
	background-color: black;
	color: white;
	padding: 15px;
	text-align: center;
}

</style>
</head>

<body style="background-color:LightSkyBlue;">

<ul>
<li><a href = "Home"> <h2>HOME</h2> </a></li>
<li><a href = "Team"> <h2> TEAMS </h2></a></li>
<li><a href = "Players"> <h2> PLAYERS </h2></a></li>
<li><a href = "matches.jsp"> <h2> MATCHES </h2></a></li>
</ul>
<form action="AdminLogin" method="post" align="center">
<center><h2><b><u>ADMIN LOGIN</u></b></h2></center>
  <div class="container">
    <label for="Username"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="Username" required>
	<br>
    <label for="Password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="Password" required>  
    <button type="submit">Login</button>
    <br><br>
    <span class="psw"><a href="#">Forgot Password?</a></span>
  </div>
  <br>
</form>
<footer>
	<p>Copyrights &copy; IPL 2022. All rights reserved</p>
</footer>
</body>
</html> 