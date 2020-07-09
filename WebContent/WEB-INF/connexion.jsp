
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Connexion</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="inc/css/main.css"/>" />
</head>
<header>
	<div id="titre_principal">
		<div id="logo">
			<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
			<h1>Connexion</h1>
		</div>

	</div>

	<nav>
		<ul>
			<li><a href="<c:url value="/inscriptionServlet" />">Inscription</a></li>
			<li><a href="<c:url value="inc/index.jsp"/>"><img src="inc/images/accueil.png" alt="Logo d'accueil" width=20 height=20/></a></li>
			
		</ul>
	</nav>
</header>


<body>
	
	<form method="post" action="<c:url value="/dispatchServlet" />">
		<fieldset>
		
			<legend>Connexion</legend>
			
			<p>Connectez vous</p>

			<label for="nom">login : <span class="requis">*</span></label> 
			<input	type="text" id="utilisateur" name="utilisateur"
				value="" size="20"	maxlength="60" required="required"/> <br /> <br /> <label for="motdepasse">Mot
				de passe :<span class="requis">*</span>
			</label> <input type="password" id="password" name="password" value=""
				size="20" maxlength="20" required="required"/>
			
			<br /> <br /> <input type="submit" value="Connexion"
				class="sansLabel" />
			<p>${form.resultat}</p>
		

		</fieldset>
	</form>
</body>
</html>