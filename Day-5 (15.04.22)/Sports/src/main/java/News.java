import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/News")
public class News extends HttpServlet {
private static final long serialVersionUID = 1L;

public News() {
	super();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

PrintWriter out = response.getWriter();

out.print("<h2>Welcome </h2>");
out.println("<html>");
out.println("<head>");

out.println("<body>");

out.println("Cricket");
out.println("Football");

out.println("</body>");

out.println("</head>");
out.println("</html>");
}
}