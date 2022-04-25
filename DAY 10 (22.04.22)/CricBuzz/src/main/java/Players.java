

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Players")
public class Players extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
			String sql = "select * from players";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			ArrayList<String> PlayerId = new ArrayList<>();
			ArrayList<String> Name = new ArrayList<>();		
			ArrayList<String> DOB = new ArrayList<>();		
			ArrayList<String> Born = new ArrayList<>();
			ArrayList<String> Nationality = new ArrayList<>();
			ArrayList<String> Batting = new ArrayList<>();		
			ArrayList<String> Bowling = new ArrayList<>();
			ArrayList<String> Role = new ArrayList<>();
			ArrayList<String> Franchise = new ArrayList<>();		
			
			 if(rs.next()==false){
		         out.println("Currently No Players Are Available");
		     }
			 
			 else{
		     do{
		         PlayerId.add(rs.getString(1));
		         Name.add(rs.getString(2));
		         DOB.add(rs.getString(3));
		         Born.add(rs.getString(4));
		         Nationality.add(rs.getString(5));
		         Batting.add(rs.getString(8));
		         Bowling.add(rs.getString(6));
		         Role.add(rs.getString(7));
		         Franchise.add(rs.getString(9));
		         }while(rs.next());
		     }
			 request.setAttribute("PlayerId", PlayerId);
			 request.setAttribute("Name", Name);
			 request.setAttribute("DOB", DOB);
			 request.setAttribute("Born", Born);
			 request.setAttribute("Nationality", Nationality);
			 request.setAttribute("Batting", Batting);
			 request.setAttribute("Bowling", Bowling);
			 request.setAttribute("Role", Role);
			 request.setAttribute("Franchise", Franchise);
			 
			 RequestDispatcher rd=request.getRequestDispatcher("players.jsp");  
		     rd.forward(request,response); 
		}
		catch (Exception e) {
			out.println(e);
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("players.jsp");  
	    rd.forward(request,response); 
		
	}	

}
