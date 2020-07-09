<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Catégorie des produits</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>
<header>
	<div id="titre_principal">
		<div id="logo">
			<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
			<h1>Catégories de Classic Models</h1>

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
			<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
			<c:when test="${ empty sessionScope.categorie }">
				<p class="erreur">Aucune catégorie enregistrée.</p>
			</c:when>

			<c:otherwise>
				<div id="conteneur">

					<c:forEach items="${ sessionScope.categorie}" var="categorie"
						varStatus="boucle">
						<form method="post" action="<c:url value="listProductServlet"/>">
							<div id="conteneurCategorie">
								<img src="inc/images/ProductLine/${categorie.productLine}.png"
									height=200px width=200px alt="Photo des catégories " />
								<h3>
									<c:out value="${categorie.productLine}"></c:out>
								</h3>
								<br> <input type="hidden" name="productline"
									value="${categorie.productLine}"> <input type="submit"
									value="Voir la catégorie" />

							</div>
						</form>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>
	</div>

</body>
</html>