<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
<title>Classic Models</title>
</head>

				

<body>
	<div id="accueil">
		<header>
			<div id="titre_principal">

				<div id="logo">
					<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
					<h1>Clients</h1>
					<br>
			
				</div>

			</div>
			<p>
				Bienvenue :
					<c:out
						value="${sessionScope.client.contactFirstName} ${client.contactLastName}" />
			<img src="inc/images/Customers/${client.contactFirstName} ${client.contactLastName}.jpg"
					width=80px height=80px><br>
			
			</p>
		
			</header>
		<div id="banniere_option">
	
	<nav>
		<ul>
			
			<li><a href="<c:url value="/listeCommandesServlet"/>">Historique</a></li>
			<li><a href="<c:url value="/categorieCommandeServlet"/>">Commander</a></li>
			<li></li>
			<li></li>
			<li><a href="<c:url value="/deconnexionServlet" />">Déconnexion</a></li>
		
			

		</ul>
	</nav>
	</div>

	
	</div>
	
	 <section>
			<article>
		
			<div class="d1"></div>
			<div class="conteneurDiapo"></div>
			<div class="d2"></div>
	
		</article>
	
			<aside>
				<h1>Informations</h1>
				<img src="inc/images/bulle.png" alt="" id="fleche_bulle" />
				<ul>
				<li>	Notre société leader dans la vente de  Modèles réduits de qualités vous propose un choix multiple d'une très grande précision
				de reproduction.</li>
				<li><img src="inc/images/logoCM.png" alt="logo classic model" width=200 height=200 align="bottom"/></li>
				</ul>
				
			</aside>
		</section> 
	<footer>
		<div class="contact">
		<nav>
				<ul>
					<li><a href="<c:url value="/connexionServlet" />">Conditions Générales de Vente</a></li>
					<li><a href="<c:url value="/inscriptionServlet" />">Service Client</a></li>
					<li><a href="<c:url value="/monCompte" />">Mon compte</a></li>
			

				</ul>
			</nav>
		</div>

		</footer>
</body>

</html>