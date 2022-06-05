package Servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import Classes.DBConnection;


@WebServlet(urlPatterns= {"/ModifierEtudiant"})


public class ModifierEtudiant extends HttpServlet 
{    
	

	public void init() throws ServletException{
		System.out.println("Servlet_Modifier");
	}
	

	  @Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		    doPost(request, response);		
		}
	  
	  @Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{   

		  String Matricule = request.getParameter("Matricule");
		  request.setAttribute("Matricule",Matricule);
		  
		  try{ 
			  
		        Connection connect = DBConnection.getConn();       
				Statement stmt = connect.createStatement();
				
				
				
				String sql1 = "select * from etudiant where matricule ='"+ Matricule + "'";
				ResultSet rs1 = stmt.executeQuery(sql1);
				
				
				while(rs1.next())
				{		
					request.setAttribute("Nom",rs1.getString("nom"));
					request.setAttribute("Prenom",rs1.getString("prenom"));
					request.setAttribute("Email",rs1.getString("email"));
					request.setAttribute("pwd",rs1.getString("pwd"));
					request.setAttribute("nbLivreMensuel_Autorise",rs1.getInt("nbLivreMensuel_Autorise"));
					request.setAttribute("nbLivreEmprunte",rs1.getInt("nbLivreEmprunte"));
					request.setAttribute("id_uni",rs1.getInt("id_universite"));

				}
			  }catch(Exception e){ System.out.println(e);}
		  
		  RequestDispatcher dispatcher = request.getRequestDispatcher("ModifierEtudiant.jsp");
		  dispatcher.forward(request, response);
		}
}


