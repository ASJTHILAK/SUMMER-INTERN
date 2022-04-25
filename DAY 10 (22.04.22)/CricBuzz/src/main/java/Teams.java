

import java.io.*;
import javax.servlet.*;
import java.util.*;
import java.sql.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Team")
public class Teams extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
				String sql = "select * from teams";
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				ArrayList<String> TeamId = new ArrayList<>();
				ArrayList<String> Franchise = new ArrayList<>();		
				ArrayList<String> TeamName = new ArrayList<>();		
				ArrayList<String> Trophies = new ArrayList<>();
				
				 if(rs.next()==false){
			         out.println("Currently No Teams Are Available");
			     }
				 
				 else{
			     do{
			         TeamId.add(rs.getString(1));
			         Franchise.add(rs.getString(2));
			         TeamName.add(rs.getString(3));
			         Trophies.add(rs.getString(4));
			         }while(rs.next());
			     }
				 request.setAttribute("TeamId", TeamId);
				 request.setAttribute("Franchise", Franchise);
				 request.setAttribute("TeamName", TeamName);
				 request.setAttribute("Trophies", Trophies);
				 
				 RequestDispatcher rd=request.getRequestDispatcher("teams.jsp");  
			     rd.forward(request,response); 
			}
			catch (Exception e) {
				out.println(e);
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("teams.jsp");  
		    rd.forward(request,response); 
	}	
}	
