package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(urlPatterns= {"/Etudiants"})


public class Etudiants extends HttpServlet 
{    
	
	
	public void init() throws ServletException{
		System.out.println("Servlet_Etudiants");
	}
	
	
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	  
	  	request.getRequestDispatcher("Etudiants.jsp").forward(request, response);	
				
	}
  
  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   
		doGet(request, response);
	}
}
