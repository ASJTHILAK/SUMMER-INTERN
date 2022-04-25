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
String Player_ID= request.getParameter("Player_ID");
String Name= request.getParameter("Name");
String DOB=request.getParameter("DOB");
String Born=request.getParameter("Born");
String Nationality = request.getParameter("Nationality");
String Batting=request.getParameter("Batting");
String Bowling=request.getParameter("Bowling");
String Role=request.getParameter("Role");
String Franchise = request.getParameter("Franchise");
try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
	String sql = "insert into players(PlayerId,Name,DOB,Born,Nationality,Batting,Bowling,Role,Franchise)values('"+Player_ID+"','"+Name+"','"+DOB+"','"+Born+"','"+Nationality+"','"+Batting+"','"+Bowling+"','"+Role+"','"+Franchise+"')";
	Statement st = con.createStatement();
	st.executeUpdate(sql);
	out.print("Data is successfully inserted!");
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