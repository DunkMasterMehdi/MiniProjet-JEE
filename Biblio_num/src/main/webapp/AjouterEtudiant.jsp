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
	<title>Ajouter Etudiant</title>
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
      
      <form action="AjouterEtudiant" method="POST" >
      <header>Ajouter Etudiant</header><br>
      <div class="error-text"></div>

        <div class="field input">
            <label>Matricule</label>
            <input type="number"  name="Matricule" placeholder="matricule..." required >
        </div>
        
        
        <div class="field input">
            <label>Nom</label>
            <input type="text"  name="Nom" placeholder="nom..." required >
        </div>
        

        <div class="field input">
            <label>Prènom</label>
            <input type="text"  name="Prenom" placeholder="prènom..." required >
        </div>


        <div class="field input">
            <label>Email</label>
            <input type="Email"  name="Email" placeholder="email..." required >
        </div>                

        <div class="field input">
            <label>id Université</label>
            <input type="number"  name="id_uni" placeholder="id université..." required >
        </div>



        <div class="field input">    
            <label>Mot de passe</label>
            <input type="password" name="mp"  placeholder="mot de passe..." required>
        </div>  
        


        <div class="field input">
          <label>Confirmer Mot de Passe</label>
          <input type="password" name="confirm_password"  placeholder="mot de passe..." required>
        </div><br>
                  

          <div class="buttons">
            <input type="submit" name="submit" value="Connexion" ></input>
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

