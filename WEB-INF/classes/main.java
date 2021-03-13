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
				reservedSeatDetails[5]=scanner.nextLine(); //Security code
				// reservedSeatDetails[6]=new Date().toString(); //Date Booked
				// scanner.nextLine();
				// reservedSeatDetails[7]=scanner.nextLine(); //Name
				reservedseats.add(reservedSeatDetails);
			}
			scanner.close();
		}catch(java.io.FileNotFoundException ex){		}

		out.println("<!DOCTYPE html>");
			out.println("<html>");
				out.println("<head>");
					out.println("<link rel='stylesheet' href='style.css'>");
				out.println("</head>");
				out.println("<body>");
					out.println("<h1>Charlestown Theatre Seating</h1>");
						out.println("<table>");
							out.println("<tr>");
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
							String seat;
							Boolean reserved;
							for (int i = 0 ; i<8;i++){
								out.println("<tr>");
									for (int j = 0; j <8 ; j++){
										reserved = false;
										seat= (letters[i]+(j+1));

										for (int k = 0 ; k<reservedseats.size();k++){
											if (seat.equals(reservedseats.get(k)[0])){
												String str = "\"" + reservedseats.get(k)[4]+"\"";
												out.println("<td class='reserved' onclick='myFunction("+str+")'>" +  letters[i] +"-"+ (j+1) +"</td>");
												reserved = true;
											}
										}
										
										if (!reserved){
											out.println("<td>"+ letters[i] +"-"+ (j+1) +"</td>");
										}
									}
								out.println("</tr>");
							}
						out.println("/<table>");

					// 

					out.println("<script>");

					out.println("function myFunction(k) {");
						out.println("alert(k);");
						out.println("}");
						
					out.println("</script>");
				out.println("</body>");
			out.println("</html>");
	} 
}



// out.println("<div class='container'>");

					// 	out.println("<table>");
					// 		out.println("<tr>");
					// 		out.println("<th></th>");
					// 		out.println("<th>1</th>");
					// 		out.println("<th>2</th>");
					// 		out.println("<th>3</th>  ");          
					// 		out.println("<th>4</th>");
					// 		out.println("<th>5</th>  ");          
					// 		out.println("<th>6</th>");
					// 		out.println("<th>7</th>");
					// 		out.println("<th>8</th>");
					// 		out.println("</tr>");
					// 		out.println("<tr>");
					// 			out.println("<th>A</th>");
					// 			out.println("<td>A-1</td>");
					// 			out.println("<td>A-2</td>");
					// 			out.println("<td class='reserved'>A-3</td>");
					// 			out.println("<td>A-4</td>");
					// 			out.println("<td>A-5</td>");
					// 			out.println("<td>A-6</td>");
					// 			out.println("<td>A-7</td>");
					// 			out.println("<td>A-8</td>");
					// 		out.println("</tr>");
					// 		out.println("<tr>");
					// 			out.println("<th>B</th>");
					// 			out.println("<td>B-1</td>");
					// 			out.println("<td>B-2</td>");
					// 			out.println("<td>B-3</td>");
					// 			out.println("<td>B-4</td>");
					// 			out.println("<td>B-5</td>");
					// 			out.println("<td>B-6</td>");
					// 			out.println("<td>B-7</td>");
					// 			out.println("<td>B-8</td>");
					// 		out.println("</tr>");        
					// 		out.println("<tr>");
					// 			out.println("<th>C</th>");
					// 			out.println("<td>C-1</td>");
					// 			out.println("<td>C-2</td>");
					// 			out.println("<td>C-3</td>");
					// 			out.println("<td>C-4</td>");
					// 			out.println("<td>C-5</td>");
					// 			out.println("<td>C-6</td>");
					// 			out.println("<td>C-7</td>");
					// 			out.println("<td>C-8</td>");
					// 		out.println("</tr>");       
					// 		out.println("<tr>");
					// 			out.println("<th>D</th>");
					// 			out.println("<td>D-1</td>");
					// 			out.println("<td>D-2</td>");
					// 			out.println("<td>D-3</td>");
					// 			out.println("<td>D-4</td>");
					// 			out.println("<td>D-5</td>");
					// 			out.println("<td>D-6</td>");
					// 			out.println("<td>D-7</td>");
					// 			out.println("<td>D-8</td>");
					// 		out.println("</tr>");
					// 		out.println("<tr>");
					// 			out.println("<th>E</th>");
					// 			out.println("<td>E-1</td>");
					// 			out.println("<td>E-2</td>");
					// 			out.println("<td>E-3</td>");
					// 			out.println("<td>E-4</td>");
					// 			out.println("<td>E-5</td>");
					// 			out.println("<td>E-6</td>");
					// 			out.println("<td>E-7</td>");
					// 			out.println("<td>E-8</td>");
					// 		out.println("</tr>");      
					// 		out.println("<tr>");
					// 			out.println("<th>F</th>");
					// 			out.println("<td>F-1</td>");
					// 			out.println("<td>F-2</td>");
					// 			out.println("<td>F-3</td>");
					// 			out.println("<td>F-4</td>");
					// 			out.println("<td>F-5</td>");
					// 			out.println("<td>F-6</td>");
					// 			out.println("<td>F-7</td>");
					// 			out.println("<td>F-8</td>");
					// 			out.println("</tr>");
					// 		out.println("<tr>");
					// 			out.println("<th>G</th>");
					// 			out.println("<td>G-1</td>");
					// 			out.println("<td>G-2</td>");
					// 			out.println("<td>G-3</td>");
					// 			out.println("<td>G-4</td>");
					// 			out.println("<td>G-5</td>");
					// 			out.println("<td>G-6</td>");
					// 			out.println("<td>G-7</td>");
					// 			out.println("<td>G-8</td>");
					// 		out.println("</tr>");
					// 			out.println("<tr>");
					// 			out.println("<th>H</th>");
					// 			out.println("<td>H-1</td>");
					// 			out.println("<td>H-2</td>");
					// 			out.println("<td>H-3</td>");
					// 			out.println("<td>H-4</td>");
					// 			out.println("<td>H-5</td>");
					// 			out.println("<td>H-6</td>");
					// 			out.println("<td>H-7</td>");
					// 			out.println("<td>H-8</td>");
					// 		out.println("</tr>");
					// 	out.println("</table>");

					// out.println("</div>");