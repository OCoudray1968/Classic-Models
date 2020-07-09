<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Catalogue des produits</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>
<header>
	<div id="titre_principal">
		<div id="logo">
			<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
			<h1>Historique des commandes</h1>
		</div>

	</div>

	<nav>
		<ul>
			<li><a href="<c:url value="/ConnexionServlet"/>">Connexion</a></li>
			<li><a href="<c:url value="inc/index.jsp"/>">Accueil</a></li>

		</ul>
	</nav>
</header>

<div id="banniere_image">
	<div id="banniere_description">

		Venez regarder notre catalogue... <a
			href="<c:url value="/categoriesServlet"/>" class="bouton_rouge">Retour
			aux Catégories <img src="inc/images/flecheblanchedroite.png" alt="" />
		</a>
	</div>
</div>

<body>

	<div id="corps">
		<c:choose>
			<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
			<c:when test="${ empty produit }">
				<p class="erreur">Aucun produit enregistré.</p>
			</c:when>
			<%-- Sinon, affichage du tableau. --%>
			<c:otherwise>
				<div id="conteneur">

					<c:forEach items="${produit}" var="produit" varStatus="boucle">
						<form method="post" action="<c:url value="/ordersServlet"/>">
							<div id="conteneurImage">
								<img src="inc/images/${produit.productCode}.jpg"><br>
								<h1>${ produit.productName }</h1>
								<p>Ref du produit: ${produit.productCode}</p>
								<p>${produit.productDescription }</p>
								<h2>Quantité en Stock: ${produit.quantityInStock}</h2>
								<h2>Prix de Vente: ${produit.msrp} €</h2>
								<h3>
									Qte <input type="number" name="quantite" value="quantite"
										size="2" min="1">
								</h3>
								<input type="submit" value="Valider" /> <input type="hidden"
									name="designation" value="${produit.productName}" /> <input
									type="hidden" name="codeProduit" value="${produit.productCode}" />
								<input type="hidden" name="prix" value="${produit.msrp}" />
							</div>
						</form>
					</c:forEach>
				</div>


			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>