import java.io.*;

import javax.imageio.IIOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.*;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/Booking"})


public class Booking extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext ctx = this.getServletContext();
		String cssTag = ctx.getRealPath("style.css");
		String seat = request.getParameter("seatNum");
		String securityCode =randomString();
		
		java.util.Date date=new java.util.Date();  

		out.println("<!DOCTYPE html>");
		out.println("<html>");
			out.println("<head>");
				out.println("<link rel='stylesheet' href='style.css'>");
				out.println("<script src = 'script.js'> </script>");
			out.println("</head>");
			out.println("<body>");
				out.println("<div class='container2'>");
				out.println("<h1><a class='container2' href='main'>Charlestown Theatre Seating</a></h1>");
				out.println("</div>");
				out.println("<div class='container4'>");
				out.println("<h2>Booking for Seat " + seat + "</h2>");
				out.println("<p>Security Code: "+securityCode);
				out.println("<p>Please enter your details and security code below: </p>");
				out.println("<form name= 'userDetails' action= /JavaServlets/Booking method = 'POST'>");
				out.println("UserID*: <input type='text' name = 'UserID' required/><br/>");
				out.println("Phone: <input type='text' name = 'Phone'/><br/>");
				out.println("Address: <input type='text' name = 'Address'/><br/>");
				out.println("Email*: <input type='text' name = 'Email'required/><br/>");
				out.println("Security Code*: <input type='text' name = 'SecurityCode'/><br/>");
				out.println("<input type='hidden' name='Date' value=\""+date+"\">");
				out.println("<input type='hidden' name='Seat' value=\""+seat+"\">");
				out.println("<input type='submit'onClick='return formvalidation(\""+securityCode+"\",\""+ seat + "\")'>");
				out.println("<input type='reset' value='Clear'>");				
				out.println("<a class='homeLink' href ='/JavaServlets/main'> Cancel </a>");
				out.println("</form>");
				out.println("</div>");


				out.println("<div class='container3'>");
				out.println("© Harrison Collins c3282352");
				out.println("</div>");
			out.println("</body>");


		out.println("</html>");





	}
    public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		ServletContext ctx = this.getServletContext();
		List<String> errors = new ArrayList<>();
		String fpath = ctx.getRealPath("/WEB-INF/test.txt");
		String cssTag = ctx.getRealPath("style.css");
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
				reservedSeatDetails[5]=scanner.nextLine(); //Security code
				// reservedSeatDetails[6]=new Date().toString(); //Date Booked
				// scanner.nextLine();
				// reservedSeatDetails[7]=scanner.nextLine(); //Name
				reservedseats.add(reservedSeatDetails);
			}
			scanner.close();
		}catch(java.io.FileNotFoundException ex){		}

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
				out.println("<head>");
					out.println("<link rel='stylesheet' href='style.css'>");
					out.println("<script src = 'script.js'> </script>");

				out.println("</head>");
				out.println("<body>");
				out.println("<div class='container2'>");
				out.println("<h1><a class='container2' href='main'>Charlestown Theatre Seating</a></h1>");
				out.println("</div>");

		String Seat = request.getParameter("Seat");
		String validSeat;
		String UserID = request.getParameter("UserID");
		String Phone = request.getParameter("Phone");
		String Address = request.getParameter("Address");
		String Email = request.getParameter("Email");
		String SecurityCode = request.getParameter("SecurityCode");
		int userIdCounter= 0;
		String date = request.getParameter("Date");
		Boolean seatValid = false;
		//validate seat
		String[] letters = {"A","B","C","D","E","F","G","H"};
		List<String> validSeats = new ArrayList<>();
		for (int i =0; i<letters.length; i++){
			for (int j = 0 ; j<8 ; j++){
				validSeat = letters[i] + (j+1);
				if (Seat.equals(validSeat))
				{
					seatValid = true;			
				}
			}
		}
		if (!seatValid){
			errors.add("Seat " + Seat+ " does not exist");
		}
		for (int i = 0 ; i<reservedseats.size();i++){
			if (reservedseats.get(i)[0].equals(Seat)){
				errors.add("Seat " + Seat+ " already reserved");
			}
		}
		//validate UserID\
		if (UserID==null){
			errors.add("UserID is required");
		}
		for (int i = 0; i<reservedseats.size();i++){
			if (reservedseats.get(i)[1].equals(UserID) ){
				userIdCounter++;
			}
		}
		if(userIdCounter>=3){
			errors.add("The customer has exceeded the maximum amount of 3 seats that can be booked");
		}

		//validate email
		if (Email == null){
			errors.add("Email is required");
		}
		int index = Email.indexOf('@');
		if (index==-1){
			errors.add("Email must have an @ symbtol");
		}
		if (errors.isEmpty())
		{
			String outputPath = ctx.getRealPath("/WEB-INF/test.txt");
			File fout = new File(outputPath);
			FileOutputStream fos = new FileOutputStream(fout);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			for (int i = 0; i < reservedseats.size(); i++) {
				bw.write(reservedseats.get(i)[0]);
				bw.newLine();
				bw.write(reservedseats.get(i)[1]);
				bw.newLine();
				bw.write(reservedseats.get(i)[2]);
				bw.newLine();
				bw.write(reservedseats.get(i)[3]);
				bw.newLine();
				bw.write(reservedseats.get(i)[4]);
				bw.newLine();
				bw.write(reservedseats.get(i)[5]);
				bw.newLine();
			}
			bw.write(Seat);
			bw.newLine();
			bw.write(UserID);
			bw.newLine();
			bw.write(Phone);
			bw.newLine();
			bw.write(Address);
			bw.newLine();
			bw.write(Email);
			bw.newLine();
			bw.write(date);
			bw.newLine();
			bw.close();
			out.println("<h2>Success!</h2><p>Seat " + Seat + " has been successfully booked</p>");

		}
		else{
			out.println("<p>Failure! - "+errors+ "</p>");
		}
			
	out.println("<a class='homeLink' href ='/JavaServlets/main'> Back to main page </a>");
	out.println("<div class='container3'>");
	out.println("© Harrison Collins c3282352");
	out.println("</div>");
	out.println("</body>");
	out.println("</html>");
	}

		public String randomString(){
	//Code referenced from https://www.programiz.com/java-programming/examples/generate-random-string
		String availableChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ01234567890123456789";
    // create random string builder
    StringBuilder sb = new StringBuilder();

    // create an object of Random class
    Random random = new Random();

    // specify length of random string
    int length = 6;

    for(int i = 0; i < length; i++) {

      // generate random index number
      int index = random.nextInt(availableChars.length());

      // get character specified by index
      // from the string
      char randomChar = availableChars.charAt(index);

      // append the character to string builder
      sb.append(randomChar);
    }

    String randomString = sb.toString();
	return randomString;
	}
    
}
