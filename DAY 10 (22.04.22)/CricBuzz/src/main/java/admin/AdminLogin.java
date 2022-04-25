package admin;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	public static boolean validate(String name,String pass){  
		boolean status=false;
		try{  
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cricbuzz","root","thilak");
		PreparedStatement ps=con.prepareStatement("select * from admin where Username='"+name+"' and Password='"+pass+"'");  
		 
		ResultSet rs=ps.executeQuery();  
		status=rs.next();  
		          
		}catch(Exception e){System.out.println(e);}  
		return status;  
		}
	
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String n=request.getParameter("Username");  
	    String p=request.getParameter("Password");  
	     
	    if(validate(n,p)) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("Uname",n);
	    	RequestDispatcher rd=request.getRequestDispatcher("adminHome.jsp");  
	        rd.forward(request, response);  
	    }
	    else{  
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('Username or password is incorrect');");
	    	out.println("location='Home';");
	    	out.println("</script>");
	    }  
	    
	    out.close();  
	}  
}  

