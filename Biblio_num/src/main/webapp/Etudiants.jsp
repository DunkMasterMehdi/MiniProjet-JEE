<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.sql.*,Classes.*"%>
 
<%   
	if (session.getAttribute("user") == null) {
		
		   System.out.println("No session found");
		    response.sendRedirect("index.jsp");
		}
 %>


 
<html>
<head>
	<meta charset="UTF-8">
	<title>Etudiants</title>
	<link rel="stylesheet" href="style.css">
</head>

<body class="container">

     <div class="navbar-container">
      	 <div class= "navbar-links">	
      	 <a href="AjouterEtudiant" >Ajouter Etudiant</a>
	     </div>
	     
	     <div class="navbar-settings">
	        <i onclick="Dropdown();"><label>Paramétres</label></i>
	        
	        <div id="settings_dropdown" style="display: none;">
	         	<a href="Logout" >Déconnecter</a>
	        </div>
        </div>
      </div>

  	 <%
	  try{ 
	        Connection connect = DBConnection.getConn();       
			Statement stmt = connect.createStatement();
			String sql1 = "select * from etudiant; ";
			ResultSet resultSet = stmt.executeQuery(sql1);
				%>      
      
      <div class="body-container">
       <table id="Table_users">
        <thead>
          <tr>
            
            <th>Matricule</th>
            <th>Nom</th>
            <th>Prènom</th>
            <th>Email</th>           
            <th>Livres_Autorisé</th>
            <th>Livres_Emprenté</th>            
            <th>id_Université</th>
            <th>Action</th>
          </tr>
        </thead>
        
			<% while(resultSet.next()){ %>
	    	  <tr>
	    	  <form action="ModifierEtudiant" method="POST" >
		    	  <td><label><%=resultSet.getString("matricule") %></label> 
		    	  <input type="text" name="Matricule" value=<%=resultSet.getString("matricule") %> style ="display: none"></td> 
		    	  <td><%=resultSet.getString("nom") %></td>
		    	  <td><%=resultSet.getString("prenom") %></td>
		    	  <td><%=resultSet.getString("email") %></td>
		    	  <td><%=resultSet.getString("nbLivreMensuel_Autorise") %></td>
		    	  <td><%=resultSet.getString("nbLivreEmprunte") %></td>
		    	  <td><%=resultSet.getString("id_universite") %></td>
		    	  <td><input type="submit" value="Modifier" class='table_button'> 
		      </form> 
			      <form action="Supp" method="POST" >
			    	  <input type="text" name="Matricule" value=<%=resultSet.getString("matricule") %> style ="display: none" >
			    	  <input type="submit" value="Supprimer" class='table_button'> 
			    	  <input type="button" value="Bonus" class='table_button'> 
		    	  </form>
		    	 
		      </td>
	    	  </tr>
	    <% }
		} catch (Exception e) {e.printStackTrace();}%>

       </table>
      </div>

</body>

	<script>
	   function Dropdown(){
		      dropdown = document.getElementById("settings_dropdown");
		      if(dropdown.style.display == "none") dropdown.style.display = "flex";
		      else dropdown.style.display = "none" ;
		    }
	</script>
	
</html>