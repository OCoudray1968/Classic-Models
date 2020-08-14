
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Inscription</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>
<body>
<header>
	<div id="titre_principal">
		<div id="logo">
			<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
			<h1>Demande d'inscription</h1>
		</div>

	</div>

	<nav>
		<ul>
			
			<li><a href="<c:url value="inc/index.jsp"/>"><img src="inc/images/accueil.png" alt="Logo d'accueil" width=20 height=20/></a></li>

		</ul>
	</nav>
</header>
	<div id="corps">
	
		<form method="post" action="<c:url value="/inscriptionServlet" />">
			<fieldset>
			<legend>Contact</legend>
				<label for="customername">SOCIETE :<span class="requis">*</span></label><input type="text"  name="customername" required="required"/>
				<br/><br/>
				<label for="contatclastname">Nom Contact :<span class="requis">*</span></label><input type="text"name="contactlastname" required="required"/>
				<br/><br/>
				<label for="contactfirstname">Prenom Contact :</label><input type="text"  name="contactfirstname"/>
			</fieldset>	
			<fieldset>	
			
			<legend> Coordonnées</legend>
				<label for="phone">Téléphone :</label><input type="text" name="phone" pattern="^(0[1-68])(?:[ _.-]?(\\d{2})){4}$"/> 
				<br/><br/>
				<label for="Email">Email <span class="requis">*</span></label><input type="email" pattern="*@[a-zA-Z].*"/>
				<br/><br/>
				<label for="addressline1">Adresse 1 : <span class="requis">*</span></label><input type="text" name="addressline1" required="required"/>
				<br/><br/>
				<label for="addressline2">Adresse 2 :</label><input type="text" name="addressline2"/>		
				<br/><br/>
				<label for="postalcode">Code Postal : <span class="requis">*</span></label><input type="text"  name="postalcode" pattern="[0-9]{5}$" required="required"/>
				<br/><br/>
				<label for="city"> Ville : <span class="requis">*</span></label><input type="text"  name="city" required="required"/>
				<br/><br/>
				<label for="state">Etat :</label><input type="text" name="state" />	
				<br/><br/>
				<label for="country">Pays :</label><input type="text"  name="country"/>
				<br/><br/> <br/><br/>
			</fieldset>
			<fieldset>
			<legend>Identifiant</legend>
				<label for="login">Login : <span class="requis">*</span></label><input type ="text"  name="login" required="required"/>
				<br/><br/> 
				<label for="pwd">Password : <span class="requis">*</span></label>	<input type ="text"  name="pwd" required="required"/>
				<br/><br/>
			</fieldset>
			<div >
				<input type= "submit" value="Valider"/>	<input type="reset" value="Remettre à zéro"/>
			</div>
			</form>			
		
	
		
</div>
</body>
</html>