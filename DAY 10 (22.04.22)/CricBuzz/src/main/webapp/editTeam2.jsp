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
String Franchise = request.getParameter("Franchise");
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
	String sql = "DELETE FROM teams where Franchise ='"+Franchise+"'";
	Statement st = con.createStatement();
	st.executeUpdate(sql);
	String sql2 = "DELETE FROM players where Franchise ='"+Franchise+"'";
	Statement st2 = con.createStatement();
	st.executeUpdate(sql2);
	out.print("Data is successfully inserted!");
	RequestDispatcher rd=request.getRequestDispatcher("addTeam.jsp");
	rd.forward(request,response);
}
catch(Exception e){
	System.out.print(e);
    e.printStackTrace();
}
 %>
</body>
</html>