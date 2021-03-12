import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
@WebServlet(urlPatterns = {"/OtherSimpleMessage"})
public class OtherSimpleMessage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<h1>Headers 1 </h1>");
		out.println("<p>Hi welcome to this server applet</p>");

	} 
}