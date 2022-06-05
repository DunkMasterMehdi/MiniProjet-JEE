package Classes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EtudiantRepository implements I_EtudiantRepository  {  
	

	
	public EtudiantRepository(){
			
		}	
	
	
	@Override
	public void add(Etudiant E) throws SQLException
	{
		
 
		Connection connect = DBConnection.getConn(); //DBConnection -> Singleton 
		
		Statement stmt = connect.createStatement();
		
		// J'ai ajout� E.getPwd() dans sql
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "','" + E.getPwd() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
			//journal.outPut_Msg("log : Ajout dans la BD r�ussi de l'�tudiant du Matricule " + E.getMatricule());
			}
		
		else if (rs == 0){
				//journal.outPut_Msg("log : Echec de l'ajout dans la BD de l'�tudiant du Matricule " + E.getMatricule());
			}
		
		//connect.close(); C'est mieux de garder la connection ouverte (Singleton)
	 }

	
	@Override
	public boolean Exists(int mat) throws SQLException	
	{
		Connection connect=DBConnection.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where matricule=" + mat;
		ResultSet rs = stmt.executeQuery(sql);         //J'ai remplac� stmt.execute(sql); par stmt.executeQuery(sql);
		
		
		if (rs.next())  //If ResultSet rs is not empty
	      {       
			//journal.outPut_Msg("logBD--- : l'�tudiant avec ce matricule existe d�ja dans la BD : " + mat);   
			return true;
	      }
		
		else    //If ResultSet rs is empty
		{
			//journal.outPut_Msg("logBD--- : l'�tudiant avec ce matricule n'existe pas :" + mat);
			return false;
		}
	}

	@Override
	public boolean Exists(String email) throws SQLException	
	{
		Connection connect=DBConnection.getConn();
		
		Statement stmt = connect.createStatement();
		
		String sql = "select * from etudiant where email='"+ email +"'";
		ResultSet rs = stmt.executeQuery(sql);       //J'ai remplac� stmt.execute(sql); par stmt.executeQuery(sql);
		
		if (rs.next())  //If ResultSet rs is not empty
		{
			//journal.outPut_Msg("logBD--- : email existe dans la BD : " + email);
			return true;
		}
		
		else  //If ResultSet rs is empty
		{
			//journal.outPut_Msg("logBD--- : email n'existe pas : " + email);	
			return false;
		}

		
	}
	
	@Override
	public boolean Verification(int mat, String email) throws SQLException	
	{
		return ( Exists(email) || Exists(mat) || email == null || email.length() == 0 );
		
	}
	
}
