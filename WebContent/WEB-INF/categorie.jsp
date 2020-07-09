<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Cat�gorie des produits</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>
<header>
	<div id="titre_principal">
		<div id="logo">
			<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
			<h1>Cat�gories de Classic Models</h1>

		</div>

	</div>

	<nav>
		<ul>
			<li><a href="<c:url value="/connexionServlet"/>">Connexion</a></li>
			<li><a href="<c:url value="inc/index.jsp"/>">Accueil</a></li>

		</ul>
	</nav>
</header>

<div id="banniere_image"></div>

<body>

	<div id="corps">
		<c:choose>
			<%-- Si aucune commande n'existe en session, affichage d'un message par d�faut. --%>
			<c:when test="${ empty sessionScope.categorie }">
				<p class="erreur">Aucune cat�gorie enregistr�e.</p>
			</c:when>

			<c:otherwise>
				<div id="conteneur">

					<c:forEach items="${ sessionScope.categorie}" var="categorie"
						varStatus="boucle">
						<form method="post" action="<c:url value="listProductServlet"/>">
							<div id="conteneurCategorie">
								<img src="inc/images/ProductLine/${categorie.productLine}.png"
									height=200px width=200px alt="Photo des cat�gories " />
								<h3>
									<c:out value="${categorie.productLine}"></c:out>
								</h3>
								<br> <input type="hidden" name="productline"
									value="${categorie.productLine}"> <input type="submit"
									value="Voir la cat�gorie" />

							</div>
						</form>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>