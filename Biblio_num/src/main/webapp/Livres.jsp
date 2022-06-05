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
	<title>Livres</title>
	<link rel="stylesheet" href="style.css">
</head>

<body>
 
  <div class="container">
	
     <div class="navbar-container">
     
	     <div class="navbar-settings">
	        <i onclick="Dropdown();"><label>Paramétres</label></i>
	        
	        <div id="settings_dropdown" style="display: none;">
	         	<a href="Logout" >Déconnecter</a>
	        </div>
        </div>
      </div>


   <div class="search_container">
    <div id="alert"> </div>
    <div class="search">
      <input type="text" id="Input" placeholder="Rechercher ici..." > 
      <button type='button' onclick="Main_Search();"></button>
    </div>
   </div>


	<%
	  try{ 
		  
	        Connection connect = DBConnection.getConn();       
			Statement stmt = connect.createStatement();
			String sql1 = "select * from livres; ";
			ResultSet resultSet = stmt.executeQuery(sql1);
				%>
   
   
   <div class="body-container">
	    <table id="TableLivres">
	    
	      <thead>
	        <tr>
	          <th id="titre">Titre</th> 
	          <th id="auteur">Domaine</th>
	          <th id="action">Action</th>
	        </tr>    
	      </thead>
	      
	      <% while(resultSet.next()){ %>
	    	  <tr>
	    	  <td><%=resultSet.getString("titre") %></td>
	    	  <td><%=resultSet.getString("domaine") %></td>
	    	  <td> <input type="submit" value="Telecharger" class='table_button'>   </td>
	    	  </tr>
	    <% 
				}
		} catch (Exception e) {
				e.printStackTrace();
			}
		%>
	    </table>
    </div>
   
  </div> 
</body>

	<script>
	   function Dropdown(){
		      dropdown = document.getElementById("settings_dropdown");
		      if(dropdown.style.display == "none") dropdown.style.display = "flex";
		      else dropdown.style.display = "none" ;
		    }
	   
	   function Main_Search() {

		    var exists = false, found = false, n, j, txtValue, td, label;
		    var input = document.getElementById("Input");
		    var filter = input.value;
		    var table = document.getElementById("TableLivres");
		    var tr = table.getElementsByTagName("tr");
		    
		    for (n = 0; n < filter.length; n++) {
		      var c = "0";
		      switch (filter[n]) {

		        case 'Â': c = "A"; break;
		        case 'Ã': c = "A"; break;
		        case 'Ç': c = "C"; break;
		        case 'È': c = "E"; break;
		        case 'É': c = "E"; break;
		        case 'Ê': c = "E"; break;
		        case 'Î': c = "I"; break
		        case 'Ô': c = "O"; break;
		        case '×': c = "x"; break;
		        case 'Û': c = "U"; break;
		        case 'à': c = "a"; break;
		        case 'á': c = "a"; break;
		        case 'â': c = "a"; break;
		        case 'ç': c = "c"; break;
		        case 'è': c = "e"; break;
		        case 'é': c = "e"; break;
		        case 'ê': c = "e"; break;
		        case 'ë': c = "e"; break;
		        case 'î': c = "i"; break;
		        case 'ô': c = "o"; break;
		        case 'û': c = "u"; break;
		        default: 
		        }
		      if (c != 0) 
		      {
		        filter = filter.split('');
		        filter[n] = c;
		        filter = filter.join('');
		      }
		    }

		  filter = filter.toUpperCase();

		 if(filter != "")
		 {
		  for (var i = 1; i < tr.length; i++) 
		  {

		    for (j = 0; j < 2; j++) 
		    {

		      td = tr[i].getElementsByTagName("td")[j];
		      if (td) {
		        txtValue = td.textContent || td.innerText; 

		        for (n = 0; n < txtValue.length; n++) 
		        {
		          c = "0";
		          switch (txtValue[n]) {
		  
		         case 'Â': c = "A"; break;
		         case 'Ã': c = "A"; break;
		         case 'Ç': c = "C"; break;
		         case 'È': c = "E"; break;
		         case 'É': c = "E"; break;
		         case 'Ê': c = "E"; break;
		         case 'Î': c = "I"; break
		         case 'Ô': c = "O"; break;
		         case '×': c = "x"; break;
		         case 'Û': c = "U"; break;
		         case 'à': c = "a"; break;
		         case 'á': c = "a"; break;
		         case 'â': c = "a"; break;
		         case 'ç': c = "c"; break;
		         case 'è': c = "e"; break;
		         case 'é': c = "e"; break;
		         case 'ê': c = "e"; break;
		         case 'ë': c = "e"; break;
		         case 'î': c = "i"; break;
		         case 'ô': c = "o"; break;
		         case 'û': c = "u"; break;
		         default: 
		         }
		          if (c != 0) 
		          {
		            txtValue = txtValue.split('');
		            txtValue[n] = c;
		            txtValue = txtValue.join('');
		          }
		        }

		        if (txtValue.toUpperCase().indexOf(filter) == -1 && !found ) 
		        {
		        	tr[i].style.display = "none";
		        } else 
		        {
		          tr[i].style.display = ""; found = true; exists = true; 
		          if(document.getElementById("alert").lastChild) document.getElementById("alert").removeChild(document.getElementById("alert").lastChild);
			        label = document.createElement("label");
			        label.textContent="Résultat trouvé";
			        document.getElementById("alert").appendChild(label);
		        }
		      }
		    } 
		    found = false;
		   } 
		   if(!exists) 
		     { 
		       if(document.getElementById("alert").lastChild) document.getElementById("alert").removeChild(document.getElementById("alert").lastChild);
		       label = document.createElement("label");
		       label.textContent="Aucun résultat";
		       document.getElementById("alert").appendChild(label);
		     }
		  }
		    else{  
		    	for (var i = 1; i < tr.length; i++) 
				  {
		    		tr[i].style.display = "";
				  }
		    	
		    	if(document.getElementById("alert").lastChild) document.getElementById("alert").removeChild(document.getElementById("alert").lastChild);
		      
		    }


		  }

	</script>

</html>

