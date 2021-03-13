import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;

@WebServlet(urlPatterns = {"/SimpleMessage"})
public class SimpleMessage extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext ctx = this.getServletContext();



		String fpath ="test";
		String line ="";
		try{
			fpath = ctx.getRealPath("/WEB-INF/test.txt");
			BufferedReader freader = new BufferedReader(new FileReader(fpath));
			line = freader.readLine();
			freader.close();

		}catch(java.io.FileNotFoundException ex){		}





		
		out.println("<!DOCTYPE html>");
		out.println("<h1>Headers 1 </h1>");
		
		out.println("<form action= /JavaServlets/SimpleMessage method = 'POST'>");
        out.println("UserID: <input type='text' name = 'UserID'/><br/>");
        out.println("Phone: <input type='text' name = 'Phone'/><br/>");
		out.println("Address: <input type='text' name = 'Address'/><br/>");
		out.println("Email: <input type='text' name = 'Email'/><br/>");
		out.println("Security Code: <input type='text' name = 'SecurityCode'/><br/>");

        out.println("<input type='submit'>");
		out.println("<input type='reset'>");
        out.println("</form>");
		out.println("<a href ='/JavaServlets/OtherSimpleMessage'> Link </a>");
		out.println(line);
	} 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		List<String> errors = new ArrayList<>();


		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String ageStr = request.getParameter("age");
		int age;
		out.println(name + ageStr);
		if (name.isEmpty()){
			errors.add("Name is null");
		}
		else if (name.length() < 10){
			errors.add("Name is less than 10 characters");
		}

		if(ageStr.isEmpty()){
			errors.add("Age is null");
		}
		else{
			try{
				age = Integer.parseInt(ageStr);
					if(age<0 || age>100){
					errors.add("Age must be between 0 and 100");
				}
			}catch (NumberFormatException ex){
				errors.add("Age is not a valid integer");
			}
		}

		if (errors.isEmpty()){
			out.println("Success!");

		}
		else{
			out.println(errors);

		}
		

	}


}


 