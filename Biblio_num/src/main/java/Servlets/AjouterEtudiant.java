package Servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.commons.codec.digest.DigestUtils;
import Classes.DBConnection;



@WebServlet(urlPatterns= {"/AjouterEtudiant"})


public class AjouterEtudiant extends HttpServlet 
{    
			
	String matriculee;
    String Nom ;
    String Prenom ;
    String Email ;
    String id_unii ;
    String mp ;
    String confirm_password ;
	

	public void init() throws ServletException{
		
		System.out.println("Servlet_Ajouter");
		
	}
	
	
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	   
	  	//getParameters 
	     matriculee = request.getParameter("Matricule");
	     Nom = request.getParameter("Nom"); 
	     Prenom = request.getParameter("Prenom"); 
	     Email = request.getParameter("Email"); 
	     id_unii = request.getParameter("id_uni");
	     mp = request.getParameter("mp"); 
	     confirm_password = request.getParameter("confirm_password");
	    
	     
	    if(matriculee!=null && Nom!=null && Prenom!=null && Email!=null && id_unii!=null && mp!=null &&confirm_password!=null) {
	    	
	    	int Matricule = Integer.parseInt(matriculee); 
	 	    int id_uni = Integer.parseInt(id_unii); 
	    		    
		    String mp_Hash = DigestUtils.md5Hex(mp).toUpperCase(), type_package="";

		    
		    int nbLivreMensuel_Autorise = 0;
		    int nbLivreEmprunte = 0;
		    
		    
			//Traitements
			  try{ 
				  
			        Connection connect = DBConnection.getConn();       
					Statement stmt = connect.createStatement();
					
					String sql1 = "select * from university where i_univ='"+ id_uni+"';";
					ResultSet rs1 = stmt.executeQuery(sql1); 
					
					while(rs1.next()){
						
						type_package = rs1.getString("package");					
						
					}
					
					if(type_package.equals("Standard") ) {
						nbLivreMensuel_Autorise = 10;
					}
					if(type_package.equals("Premium")) {
						nbLivreMensuel_Autorise = 20;
					}
					
					
					String sql = "INSERT into etudiant values (" + Matricule + ",'" + Nom + "','" + Prenom +
							"','" + Email + "','" + mp_Hash + "'," + nbLivreMensuel_Autorise +
							"," + nbLivreEmprunte + "," + id_uni +")";
				
					int rs = stmt.executeUpdate(sql);					
					
					if (rs == 1){
						System.out.println("Etudiant ajouté");
						request.getRequestDispatcher("Etudiants").forward(request, response);	
						
						}else {
							System.out.println("Erreur d'ajoute"); 
							request.getRequestDispatcher("AjouterEtudiant.jsp").forward(request, response);	
						}
					
				  }catch(Exception e){ System.out.println(e);}  
	    }
	    else {
			request.getRequestDispatcher("AjouterEtudiant.jsp").forward(request, response);		
	    }

	
				
	}
  
  @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{   
		doGet(request, response);
	}
}
