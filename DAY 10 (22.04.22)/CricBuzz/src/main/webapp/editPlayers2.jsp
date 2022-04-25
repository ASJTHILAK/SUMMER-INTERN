<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DELETE TEAM</title>
</head>
<body>

<%
String Player_ID = request.getParameter("Player_ID");
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
	String sql = "DELETE FROM players where PlayerId ='"+Player_ID+"'";
	Statement st = con.createStatement();
	st.executeUpdate(sql);
	out.println("Data is successfully deleted!");
	RequestDispatcher rd=request.getRequestDispatcher("addPlayers.jsp");
	rd.forward(request,response);
}
catch(Exception e){
	System.out.print(e);
    e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher("addPlayers.jsp");
rd.forward(request,response);
 %>
</body>
</html>