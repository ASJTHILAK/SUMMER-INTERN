<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD TEAM</title>
</head>
<body>

<%
String Team_ID = request.getParameter("Team_ID");
String Franchise = request.getParameter("Franchise");
String Team_Name=request.getParameter("Team_Name");
String Trophies=request.getParameter("Trophies");
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
	String sql = "insert into teams(TeamID,Franchise,Team_Name,Trophies)values('"+Team_ID+"','"+Franchise+"','"+Team_Name+"','"+Trophies+"')";
	Statement st = con.createStatement();
	st.executeUpdate(sql);
	String disp="Hello"; 
	request.setAttribute("disp",disp);
	RequestDispatcher rd=request.getRequestDispatcher("addTeam.jsp");
	rd.forward(request,response);
}
catch(Exception e){
	System.out.print(e);
    e.printStackTrace();
}
RequestDispatcher rd=request.getRequestDispatcher("addTeam.jsp");
rd.forward(request,response);
 %>
</body>
</html>