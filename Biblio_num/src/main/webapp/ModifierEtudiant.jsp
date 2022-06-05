<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%   
	if (session.getAttribute("user") == null) {
		
		   System.out.println("No session found");
		    response.sendRedirect("index.jsp");
		}

 %>

<html>
<head>
	<meta charset="UTF-8">
	<title>Modifier Etudiant</title>
	<link rel="stylesheet" href="style.css">
</head>

<body class="container">

     <div class="navbar-container">
     
	     <div class="navbar-settings">
	        <i onclick="Dropdown();"><label>Paramétres</label></i>
	        
	        <div id="settings_dropdown" style="display: none;">
	         	<a href="Logout" >Déconnecter</a>
	        </div>
        </div>
      </div>
     
     
    <div class="body-container"> 
     <section class="form signup">
      
      <form action="Modif" method="POST" >
      <header>Modifier Utilisateur</header><br>
      <div class="error-text"></div>


        <div class="field input">
            <label>Matricule</label>
            <input type="text"  name="Matricule" value="<%=request.getAttribute("Matricule")%>" placeholder="matricule..."  readonly required>
        </div>
        
        
        <div class="field input">
            <label>Nom</label>
            <input type="text"  name="Nom" value="<%=request.getAttribute("Nom")%>" placeholder="nom..."  required>
        </div>
        

        <div class="field input">
            <label>Prènom</label>
            <input type="text"  name="Prenom" value="<%=request.getAttribute("Prenom")%>" placeholder="prènom..."  required>
        </div>

        <div class="field input">
            <label>Email</label>
            <input type="Email"  name="Email" value="<%=request.getAttribute("Email")%>" placeholder="email..."  required>
        </div>                

        <div class="field input">
            <label>Livres Autorisé</label>
            <input type="number"  name="nbLivreMensuel_Autorise" value="<%=request.getAttribute("nbLivreMensuel_Autorise")%>" placeholder="Livres Autorisé..."  required>
        </div>
        
        <div class="field input">
            <label>Livres Emprunté</label>
            <input type="number"  name="nbLivreEmprunte" value="<%=request.getAttribute("nbLivreEmprunte")%>" placeholder="Livres Emprunté..."  required>
        </div>
        
        <div class="field input">
            <label>id Université</label>
            <input type="number"  name="id_uni" value="<%=request.getAttribute("id_uni")%>" placeholder="id université..."  required>
        </div>                

          <div class="buttons">
            <input type="submit" value="Confirmer" ></input>
            <a href="Etudiants">Annuler</a>
          </div>
      </form>
     </section>
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

