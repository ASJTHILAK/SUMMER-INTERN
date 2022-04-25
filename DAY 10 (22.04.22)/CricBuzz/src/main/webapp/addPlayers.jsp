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
<center><h1><b><u> IPL TEAMS </u></b> </h1></center>
<%	
	response.setHeader("cache-Control","no-cache,no-store,must-revalidate");
	response.setHeader("Pragma","no-cache");
	response.setHeader("Expires","0");
	if(session.getAttribute("Uname")==null){
		response.sendRedirect("Home");
	}
	int i=1;
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
	String sql = "select * from players";
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(sql);
	
	 if(rs.next()==false){
         out.println("Currently No Teams Are Available");
     }
	 
	 else{%>
     <table align="center" border="5" bgcolor="Lightgrey" width="90%" bordercolor="black" height: 150px;>
     <b><tr><th height = "90px">S.no</th><th>Player ID</th><th>Name</th><th>DOB</th><th>Born</th><th>Nationality</th><th>Batting</th><th>Bowling</th><th>Role</th><th>Franchise</FONT></th></tr></b>
     <%do{%>
         <tr height = "45px" align ="center">
         <td><%= i++ %></td>
         <td><%=rs.getString(1)%></a></td>
         <td><%= rs.getString(2)%></td>         
         <td><%= rs.getString(3)%></td>
         <td><%= rs.getString(4)%></td>
         <td><%= rs.getString(5)%></td>
         <td><%= rs.getString(6)%></td>
         <td><%= rs.getString(7)%></td>
         <td><%= rs.getString(8)%></td>
         <td><%= rs.getString(9)%></td>
         </tr>
         <%}while(rs.next());
     }
%>

<table align = "center">
<tr>
  
<form id="addform" method="post" action="editPlayer.jsp" border="5px solid black">
<td>
<h2> <b><u> ADD PLAYERS </u></b> </h2>
Player ID:<br>
<input type="text" name="Player_ID" maxlength ="5" required>
<br>
Name:<br>
<input type="text" name="Name" maxlength ="50" onkeypress="return /[a-z]/i.test(event.key)" required>
<br>
DOB:<br>
<input type="date" name="DOB" required>
<br>
Born:<br>
<input type="text" name="Born" maxlength ="20" onkeypress="return /[a-z]/i.test(event.key)" required>
<br>
Nationality:<br>
<input type="text" name="Nationality" maxlength ="50" onkeypress="return /[a-z]/i.test(event.key)" required>
<br>
Batting:<br>
<input type="text" name="Batting" maxlength ="50" onkeypress="return /[a-z]/i.test(event.key)" required>
<br>
Bowling:<br>
<input type="text" name="Bowling" maxlength ="50" onkeypress="return /[a-z]/i.test(event.key)" required>
<br>
Role:<br>
<input type="text" name="Role" maxlength ="50" onkeypress="return /[a-z]/i.test(event.key)" required>
<br>
Franchise:<br>
<input type="text" name="Franchise" maxlength ="5" onkeypress="return /[a-z]/i.test(event.key)" required>
<br><br>
<input type="submit" value="submit"required>
</td>
</form>
<td> </td>
<form id="deleteform" method="post" action="editPlayers2.jsp" border="5px solid black">
<td align="right">
<h2> <b><u> DELETE PLAYERS </u></b> </h2>
Player_ID:<br>
<input type="text" name="Player_ID" maxlength ="5"required>
<br>
<br><br>
<input type="submit" value="submit">
</td>
</form>

</tr>
</table>
</body>
</html>