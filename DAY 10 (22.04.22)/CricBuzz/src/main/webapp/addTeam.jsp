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
<center><h1><b><u> ADD TEAMS </u></b> </h1></center>
<%	
	response.setHeader("cache-Control","no-cache,no-store,must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires","0");
	if(session.getAttribute("Uname")==null){
		response.sendRedirect("Home");
	}
	int i=1;
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
	String sql = "select * from teams";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
	
	 if(rs.next()==false){
         out.println("Currently No Teams Are Available");
     }
	 
	 else{%>
     <table align="center" border="5" bgcolor="Lightgrey" width="90%" bordercolor="black" height: 150px;>
     <b><tr><th height = "90px">S.no</th><th>Team ID</th><th>Franchise</th><th>Team Name</th><th>Trophies</th></FONT></th></tr></b>
     <%do{%>
         <tr height = "45px" align ="center">
         <td><%= i++ %></td>
         <td><%=rs.getString(1)%></a></td>
         <td><%= rs.getString(2)%></td>         
         <td><%= rs.getString(3)%></td>
         <td><%= rs.getString(4)%></td>
         </tr>
         <%}while(rs.next());
     }
	 
%>

<table align = "center">
<tr>
  
<form id="addform" method="post" action="editTeam.jsp" border="5px solid black">
<td>
<h2> <b><u> ADD TEAM </u></b> </h2>
TEAM ID:<br>
<input type="text" name="Team_ID" maxlength ="5" required>
<br>
Franchise:<br>
<input type="text" name="Franchise" maxlength ="5" onkeypress="return /[a-z]/i.test(event.key)" required>
<br>
TEAM NAME:<br>
<input type="text" name="Team_Name" maxlength ="50" onkeypress="return /[a-z]/i.test(event.key)" required>
<br>
TROPHIES:<br>
<input type="number" name="Trophies" maxlength ="5"  required>
<br><br>
<input type="submit" value="submit"required>
</td>
</form>
<td> </td>
<form id="deleteform" method="post" action="editTeam2.jsp" border="5px solid black">
<td align="right">
<h2> <b><u> DELETE TEAM </u></b> </h2>
FRANCHISE:<br>
<input type="text" name="Franchise" maxlength ="5" onkeypress="return /[a-z]/i.test(event.key)" required>
<br>
<br><br>
<input type="submit" value="submit">
</td>
</form>

</tr>
</table>
</body>
</html>