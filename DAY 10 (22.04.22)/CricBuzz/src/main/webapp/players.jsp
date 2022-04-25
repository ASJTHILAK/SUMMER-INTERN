<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%Class.forName("com.mysql.jdbc.Driver");%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PLAYERS</title>
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
</form><center><b><u> PLAYERS </u></b> </h1></center>
<%
	int i=1;
	ArrayList<String> PlayerId = (ArrayList<String>)request.getAttribute("PlayerId");
	ArrayList<String> Name = (ArrayList<String>)request.getAttribute("Name");
	ArrayList<String> DOB = (ArrayList<String>)request.getAttribute("DOB");
	ArrayList<String> Born = (ArrayList<String>)request.getAttribute("Born");
	ArrayList<String> Nationality = (ArrayList<String>)request.getAttribute("Nationality");
	ArrayList<String> Batting = (ArrayList<String>)request.getAttribute("Batting");
	ArrayList<String> Bowling = (ArrayList<String>)request.getAttribute("Bowling");
	ArrayList<String> Role = (ArrayList<String>)request.getAttribute("Role");
	ArrayList<String> Franchise = (ArrayList<String>)request.getAttribute("Franchise");
	%>
     <table align="center" border="5" bgcolor="Lightgrey" width="90%" bordercolor="black" height: 150px;>
     <b><tr><th height = "90px">S.no</th><th>Name</th><th>DOB</th><th>Born</th><th>Nationality</th><th>Batting</th><th>Bowling</th><th>Role</th><th>Franchise</FONT></th></tr></b>
     <%for(int j=0;j<PlayerId.size();++j){%>
         <tr height = "45px" align ="center">
         <td><%= i++ %></td>
         <td><%= Name.get(j)%></td>         
         <td><%= DOB.get(j)%></td>
         <td><%= Born.get(j)%></td>
         <td><%= Nationality.get(j)%></td>
         <td><%= Bowling.get(j)%></td>
         <td><%= Role.get(j)%></td>
         <td><%= Batting.get(j)%></td>
         <td><a href="players2.jsp?teamId=<%=Franchise.get(j)%>"><%=Franchise.get(j)%></a></td>
         </tr>
         <%}%>
</body>
</html>