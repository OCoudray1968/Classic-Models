
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Cat�gorie des produits</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>
<body>
<div id="accueil">
		<header>
			<div id="titre_principal">

				<div id="logo">
					<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
					<h1>Cat�gorie de Produits</h1>
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
			<li><a href="<c:url value="/deconnexionServlet" />">D�connexion</a></li>
		
			

		</ul>
	</nav>
	</div>

	
	</div>
	
<div id="contact" >
<c:choose>
			<%-- Si aucune commande n'existe en session, affichage d'un message par d�faut. --%>
			<c:when test="${ empty sessionScope.categorie }">
				<p class="erreur">Aucune cat�gorie enregistr�e.</p>
			</c:when>

			<c:otherwise>
		<c:forEach items="${ sessionScope.categorie}" var="categorie" varStatus="boucle">
		
		<a
				id="photo_min" href="<c:url value="/listProductCommandeServlet"><c:param name="productline" value="${categorie.productLine}" /></c:url>">
				<img src="inc/images/ProductLine/${categorie.productLine}.png"
				alt="Logo de Classic Models" />
				
		</a>
			</c:forEach>
			
			</c:otherwise>
		</c:choose>
</div>


</body>
</html>