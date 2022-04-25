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
<li><a href = "Home"> <h2>HOME</h2> </a></li>
<li><a href = "Team"> <h2> TEAMS </h2></a></li>
<li><a href = "Players"> <h2> PLAYERS </h2></a></li>
<li><a href = "matches.jsp"> <h2> MATCHES </h2></a></li>
</ul>
<h1 "display:inline;"> <form>
 <input type="button" value="&lArr;" onclick="history.go(-1)" style="height: 50px; width: 50px; left: 250; top: 250;">
</form><center><b><u> IPL TEAMS </u></b> </h1></center>
<%
	int i=1;
	ArrayList<String> TeamId = (ArrayList<String>)request.getAttribute("TeamId");
	ArrayList<String> Franchise = (ArrayList<String>)request.getAttribute("Franchise");
	ArrayList<String> TeamName = (ArrayList<String>)request.getAttribute("TeamName");
	ArrayList<String> Trophies = (ArrayList<String>)request.getAttribute("Trophies");
	%>
     <table align="center" border="5" bgcolor="Lightgrey" width="90%" bordercolor="black" height: 150px;>
     <b><tr><th height = "90px">S.no</th><th>Franchise</th><th>Team Name</th><th>Trophies</FONT></th></tr></b>
     
     <%for(int j=0;j<TeamId.size();++j){%>
         <tr height = "45px" align ="center">
         <td><%= i++ %></td>
         <td><a href="players2.jsp?teamId=<%=Franchise.get(j)%>"><%=Franchise.get(j)%></a></td>
         <td><%= TeamName.get(j)%></td>
         <td><%= Trophies.get(j)%></td>
         </tr>
         <%}%>
	 
</body>
</html>


