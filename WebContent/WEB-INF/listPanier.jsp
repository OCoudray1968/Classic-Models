<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Vue du panier en cours</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>

<body>
	<form method="post" action="<c:url value="/confirmationPanier" />">
		<H2>${sessionScope.client.customerName}</H2>
		<div id="corps">
			<c:choose>
				<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
				<c:when test="${ empty panier }">
					<p class="erreur">Aucun panier en cours.</p>
				</c:when>
				<%-- Sinon, affichage du tableau. --%>
				<c:otherwise>

					<div id="conteneurPanier">
						<table>
							<tr>
								<th>Index</th>
								<th>Code Produit</th>
								<th>Photo</th>
								<th>Quantités commandées</th>
								<th>Prix Unitaire</th>
								<th>Total</th>


								<th class="action">Action</th>
							</tr>

							<%-- Parcours de la Map des commandes en session, et utilisation de l'objet varStatus. --%>
							<c:forEach items="${ panier }" var="panier" varStatus="boucle">
								<%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
								<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
									<%-- Affichage des propriétés du bean Commande, qui est stocké en tant que valeur de l'entrée courante de la map --%>
									<td>${boucle.index}</td>
									<td>${panier.productCode }</td>
									<td><img src="inc/images/Products/${panier.productCode}.jpg"
										width="80" height="80"></td>
									<td>${panier.quantityOrdered }</td>
									<td>${panier.priceEach}</td>
									<td>${panier.quantityOrdered*panier.priceEach}</td>





									<%-- Lien vers la servlet de suppression <c:param/>. --%>
									<td class="action"><a
										href="<c:url value="/listProductCommandeServlet"><c:param name="lignePanier" value="${boucle.index }" /></c:url>">
											<input type="hidden" name="index" value="${boucle.index}" />
											<img src="<c:url value="/inc/supprimer.png"/>"
											alt="Supprimer" />
									</a></td>
								</tr>
								<c:set var="TotalPanier"
									value="${TotalPanier+(panier.quantityOrdered*panier.priceEach)}" />

							</c:forEach>

						</table>

					</div>
				</c:otherwise>
			</c:choose>
		</div>

		<table>
			<tr>
				<th>Total du Panier</th>
				<td>${TotalPanier}€</td>
				<th><input type="submit" value="Valider votre Panier" /></th>
			</tr>
		</table>
	</form>
</body>
</html>