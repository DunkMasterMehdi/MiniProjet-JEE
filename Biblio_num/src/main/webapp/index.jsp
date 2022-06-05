<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>



<html>
<head>
	<meta charset="UTF-8">
	<title>Bibliothèque Numérique</title>
	<link rel="stylesheet" href="style.css">
</head>

<body class="body login">
  
  <div class="body-container login">

    <section class="form login">
      
      <form action="index" method="POST" autocomplete="off">
       <header>Bibliothèque Numérique</header><br>
        <div class="error-text"></div>

        <div class="field input">
          <label>Email</label>
          <input type="text" name="email" placeholder="Entrer votre email..." required >
        </div>

        <div class="field input">
          <label>Mot de Passe</label>
          <input type="password" name="password" placeholder="Entrer votre mot de passe..." required >
        </div>

        <div class="field button">
          <input type="submit" name="submit" value="Connexion" >
        </div>
        

      </form>
      
    </section>
   
   <div><br><br>
   </div>
  
  </div>
  

</body>
</html>
