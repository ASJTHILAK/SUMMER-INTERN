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
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
	String teamId = request.getParameter("teamId");
	String sql = "select * from players where Franchise='"+teamId+"'";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
	
	 if(rs.next()==false){
         out.println("Currently No Players Are Available");
     }
	 
     else{%>
     <table align="center" border="5" bgcolor="Lightgrey" width="90%" bordercolor="black" height: 150px;>
     <b><tr><th height = "90px">S.no</th><th>Name</th><th>DOB</th><th>Born</th><th>Nationality</th><th>Batting</th><th>Bowling</th><th>Role</th><th>Franchise</FONT></th></tr></b>
     <%do{%>
         <tr height = "45px" align ="center">
         <td><%= i++ %></td>
         <td><%= rs.getString(2)%></td>         
         <td><%= rs.getString(3)%></td>
         <td><%= rs.getString(4)%></td>
         <td><%= rs.getString(5)%></td>
         <td><%= rs.getString(6)%></td>
         <td><%= rs.getString(7)%></td>
         <td><%= rs.getString(8)%></td>
         <td><a href="Team"><%=rs.getString(9)%></a></td>
         </tr>
         <%}while(rs.next());
     }
%>
</body>
</html>