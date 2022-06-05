package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Classes.DBConnection;


@WebServlet(urlPatterns= {"/Modif"})

public class Modif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String matriculee = request.getParameter("Matricule");
	    String Nom = request.getParameter("Nom"); 
	    String Prenom = request.getParameter("Prenom"); 
	    String Email = request.getParameter("Email"); 
	    String id_unii = request.getParameter("id_uni");
	    String nbLivreMensuel_Autorisee = request.getParameter("nbLivreMensuel_Autorise");
	    String nbLivreEmpruntee = request.getParameter("nbLivreEmprunte");
	    		    
	    	
	    
   	 	int Matricule = Integer. parseInt(matriculee); 
	    int nbLivreMensuel_Autorise = Integer. parseInt(nbLivreMensuel_Autorisee);
	    int nbLivreEmprunte = Integer. parseInt(nbLivreEmpruntee);
	    int id_uni = Integer. parseInt(id_unii);
	    
		try{ 
			  
		        Connection connect = DBConnection.getConn();       
				Statement stmt = connect.createStatement();
				
				
				String sql = "update etudiant set nom = '" + Nom + "' , prenom = '" + Prenom + "' , email = '" + Email  +  "' , nbLivreMensuel_Autorise = '"  + nbLivreMensuel_Autorise + "' , nbLivreEmprunte = '" +nbLivreEmprunte+  "' , id_universite = '" + id_uni +"' where matricule = '" + Matricule + "'";

	
				int rs = stmt.executeUpdate(sql);
				
				if (rs == 1){
					System.out.println("Etudiant modifié");
					request.getRequestDispatcher("Etudiants").forward(request, response);	
					
					}else {
						System.out.println("Erreur de modification"); 
						response.sendRedirect("Etudiants");	
					}
				
			  }catch(Exception e){ System.out.println(e);} 
	    
	    
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
