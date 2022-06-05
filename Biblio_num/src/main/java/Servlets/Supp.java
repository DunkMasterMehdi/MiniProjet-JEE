package Servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import Classes.DBConnection;


@WebServlet(urlPatterns= {"/Supp"})


public class Supp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		System.out.println("Suppression d'etudiant");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String matriculee = request.getParameter("Matricule");

	    
   	 	int Matricule = Integer. parseInt(matriculee);
	    
		try{ 
			  
		        Connection connect = DBConnection.getConn();       
				Statement stmt = connect.createStatement();
				
				
				String sql = "delete from etudiant where matricule = '" + Matricule + "'";
				
	
				stmt.executeUpdate(sql);
				
				
			  }catch(Exception e){ System.out.println(e);} 
	    
	    response.sendRedirect("Etudiants.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
