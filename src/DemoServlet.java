import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet  extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		pw.print("<html> <body>");
		pw.print("Welcome to Servlet");
		pw.print("</body></html>");
		
		pw.close();
		
		
	}

}
