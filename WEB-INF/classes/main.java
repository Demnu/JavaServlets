import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;


@WebServlet(urlPatterns = {"/main"})
public class main extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String line;
		PrintWriter out = response.getWriter();
		ServletContext ctx = this.getServletContext();
		String cssTag = ctx.getRealPath("style.css");
		String fpath = ctx.getRealPath("/WEB-INF/test.txt");
		List<String[]> reservedseats = new ArrayList<>();
		try{
			Scanner scanner = new Scanner(new File(fpath));
			while(scanner.hasNextLine()){
				String[] reservedSeatDetails = new String[6];
				reservedSeatDetails[0]=scanner.nextLine(); //Seat Number
				reservedSeatDetails[1]=scanner.nextLine(); // UserID
				reservedSeatDetails[2]=scanner.nextLine(); //Phone
				reservedSeatDetails[3]=scanner.nextLine(); //Address
				reservedSeatDetails[4]=scanner.nextLine(); //Email
				reservedSeatDetails[5]=scanner.nextLine(); //Date
				reservedseats.add(reservedSeatDetails);
			}
			scanner.close();
		}catch(java.io.FileNotFoundException ex){		}

		out.println("<!DOCTYPE html>");
			out.println("<html>");

				out.println("<head>");
					out.println("<link rel='stylesheet' href='style.css'>");
					out.println("<script src = 'script.js'> </script>");

				out.println("</head>");
				out.println("<body onload='startTime()'>");
				out.println("<div class='container2'>");
				out.println("<h1><a class='container2' href='main'>Charlestown Theatre Seating</a></h1>");
				out.println("</div>");
						out.println("<table>");
							out.println("<tr>");
								out.println("<th></th>");
								out.println("<th>1</th>");
								out.println("<th>2</th>");
								out.println("<th>3</th>");          
								out.println("<th>4</th>");
								out.println("<th>5</th>");          
								out.println("<th>6</th>");
								out.println("<th>7</th>");
								out.println("<th>8</th>");
							out.println("</tr>");
							String[] letters = {"A","B","C","D","E","F","G","H"};
							String seat,alreadyBooked;
							Boolean reserved;
							for (int i = 0 ; i<8;i++){
								out.println("<tr>");
								out.println("<th>" + letters[i]+ "</th>");

									for (int j = 0; j <8 ; j++){
										reserved = false;
										seat= (letters[i]+(j+1));
										for (int k = 0 ; k<reservedseats.size();k++){
											if (seat.equals(reservedseats.get(k)[0])){
												alreadyBooked = "\""+letters[i] +"-"+ (j+1) + " is already booked! | UserID: " + reservedseats.get(k)[1]+" | Date Booked: " + reservedseats.get(k)[5]+"\"";
												out.println("<td class='reserved' onclick='myFunction("+alreadyBooked+")'><div>" + letters[i] +"-"+ (j+1) + "</div></td>");
												reserved = true;
											}
										}
										if (!reserved){
											out.println("<td class='notBooked'><a class='notBooked' href='/JavaServlets/Booking?seatNum="+seat+"'><div><p class='notBooked'>"+letters[i] +"-"+ (j+1)+"</p></div></a></td>");									
										}
									}
								out.println("</tr>");
							}
						out.println("</table>");
				out.println("<div class='timeContainer'><p id='time'></p>");
				
				out.println("</div>");

				out.println("<div class='container3'>");
					out.println("?? Harrison Collins c3282352");
				out.println("</div>");
				out.println("</body>");
			out.println("</html>");
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
