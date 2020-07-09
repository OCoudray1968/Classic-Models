<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
<title>Classic Models</title>
</head>
<body>
	<c:set var="today" value="<%=new java.util.Date()%>" />
	<div id="accueil">
		<header>
			<div id="titre_principal">
				<div id="logo">
					<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
					<h1>
						 Bordereau de Commande
					</h1>
					<p>
						<c:out
							value="${sessionScope.client.contactFirstName} ${client.contactLastName}" />
					</p>
					<img
						src="inc/images/Customers/${client.contactFirstName} ${client.contactLastName}.jpg"
						width=80px height=80px><br>
				</div>

			</div>

			<nav>
				<ul>
					<li><a href="<c:url value="/deconnexionServlet" />">Deconnexion</a></li>


				</ul>
			</nav>

		</header>

		<div id="banniere_image"></div>
		<form method="post" action="<c:url value="/validerBonDeCommande" />">
			<section>
				<article>


					<h1>
						<img src="inc/images/ico_epingle.png" alt="Catégorie"
							class="ico_categorie" />${sessionScope.client.customerName }</h1>
					<h1>Adresse de livraison: ${client.addressLine1 }
						${client.postalCode} ${client.city} ${client.country }</h1>
					<H2>
						Commande du :
						<fmt:formatDate value="${today}" />
					</H2>
					<br />
					<H2>
						Livraison souhaitée le :<input name="requiredDate" type="date">
					</H2>

					<h3>
						Commentaires : <input type="text" name="comments">
					</h3>

				</article>

			</section>


			<div id="corps">
				<c:choose>
					<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
					<c:when test="${ empty panier }">
						<p class="erreur">Aucun panier en cours.</p>
					</c:when>
					<%-- Sinon, affichage du tableau. --%>
					<c:otherwise>

						<div id="conteneur">
							<table>
								<tr>

									<th>Code Produit</th>
									<th>Photo</th>
									<th>Quantités commandées</th>
									<th>Prix Unitaire</th>
									<th>Total</th>



								</tr>

								<%-- Parcours de la Map des commandes en session, et utilisation de l'objet varStatus. --%>
								<c:forEach items="${ panier }" var="panier" varStatus="boucle">
									<%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
									<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
										<%-- Affichage des propriétés du bean Commande, qui est stocké en tant que valeur de l'entrée courante de la map --%>

										<td>${panier.productCode }</td>
										<td><img src="inc/images/Products/${panier.productCode}.jpg"
											width="80" height="80"></td>
										<td>${panier.quantityOrdered }</td>
										<td>${panier.priceEach}</td>
										<td>${panier.quantityOrdered*panier.priceEach}</td>





										<%-- Lien vers la servlet de suppression <c:param/>. --%>

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
					<th><input type="hidden" name="datedujour" value="${today}" />
						<input type="hidden" name="requiredDate" value="${requiredDate}" />

						<input type="submit" value="Valider votre Commande" /></th>
				</tr>
			</table>
		</form>
		<footer> </footer>
	</div>
</body>
</html>