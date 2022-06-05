package Servlets;

import Classes.DBConnection;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.codec.digest.DigestUtils;



public class Login extends HttpServlet 
{    
	
	private String email;
	private String password;
	
	
	public void init() throws ServletException{

		System.out.println("Servlet_Login");
	}
	
	
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  	//getParameters
	  	 email = request.getParameter("email");
	  	 password = request.getParameter("password");

	  	 HttpSession session = request.getSession();


	  	//First page load
	  	 if(email==null && password==null) {
	  		 request.getRequestDispatcher("index.jsp").forward(request, response);	
	  	 }
	  	 
	    //Authentification
	  	 else {  
	   
	  		 			 		    
			   String mp_Hash = DigestUtils.md5Hex(password).toUpperCase();
			   	  	

			  try{ 
				  
			        Connection connect = DBConnection.getConn();       
					Statement stmt = connect.createStatement();
					
					
					//User = Etudiant
					String sql1 = "select * from etudiant where email='" + email +"' and pwd='" + mp_Hash + "';";  
					ResultSet rs1 = stmt.executeQuery(sql1);
					
					if(rs1.next() == true) {
						
					    
					    session.setAttribute("user", "etudiant_"+email);
						request.getRequestDispatcher("Livres").forward(request, response);					  
						
					}
					else //User = Admin
					{
						
						String sql2 = "select * from admin where email='" + email +"' and pwd='" + mp_Hash + "';"; 
						ResultSet rs2 = stmt.executeQuery(sql2);
						
						if(rs2.next() == true) {
							
							session.setAttribute("user", "admin_"+email);
							request.getRequestDispatcher("Etudiants").forward(request, response);
						}
						else 
						{
							System.out.println("User doesn't exist");   //User Doesn't exist
							response.sendRedirect("index.jsp");
						}
						
					}
					
				  }catch(Exception e){ System.out.println(e);}  	 
	  		 
	  	 }
	  	 

	}
  
  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   
		doGet(request, response);
	}
}
