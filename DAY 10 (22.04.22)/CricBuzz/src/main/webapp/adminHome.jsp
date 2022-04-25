<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%Class.forName("com.mysql.jdbc.Driver");%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TEAMS</title>
<style>
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
</style>
</head>
<body style="background-color:LightSkyBlue;">
<ul>
<li><a href = "adminHome.jsp"> <h2>HOME</h2> </a></li>
<li><a href = "addTeam.jsp"> <h2> TEAMS </h2></a></li>
<li><a href = "addPlayers.jsp"> <h2> PLAYERS </h2></a></li>
<li><a href = "matches.jsp"> <h2> MATCHES </h2></a></li>
<form action = "Logout" style="float:right"> 
<input type = "submit" value="Logout">
</form>
</ul>
<center><h1> <b><u> ...WELCOME ADMIN!!! </u></b> </h1></center><br>
<center><h2> <b><u>HERE YOU CAN EDIT THE </u></b> </h2></center><br>
<center><h2> <b><u><a href="addTeam.jsp">TEAMS </a></u></b> </h2></center><br>
<center><h2> <b><u><a href="addPlayers.jsp">PLAYERS </a> </u></b> </h2></center><br>
<center><h2> <b><u> <a href="addMatch.jsp">MATCHES </a> </u></b> </h2></center><br>
<%	
	response.setHeader("cache-Control","no-cache,no-store,must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires","0");
	if(session.getAttribute("Uname")==null){
		response.sendRedirect("Home");
	}
	%>
	
</body>
</html>