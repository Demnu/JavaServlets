import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/MyServlet"})
public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException {
		// Use "request" to read incoming HTTP headers
		//(e.g.cookies) and HTML form data (e.g. data the user
		//entered and submitted)
		// Use "response" to specify the HTTP response line
		//and headers (e.g. specifying the content type,
		//setting cookies).
		PrintWriter out = response.getWriter();
		// Use "out" to send content to browser
	} 
}
