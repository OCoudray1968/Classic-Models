<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Commande des produits</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>
<body>
<div id="accueil">
		<header>
			<div id="titre_principal">

				<div id="logo">
					<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
					<h1>Commande</h1>
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
	<div id="contact" >
<c:choose>
			<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
			<c:when test="${ empty sessionScope.categorie }">
				<p class="erreur">Aucune catégorie enregistrée.</p>
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



	
		<c:choose>
			<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
			<c:when test="${ empty produit }">
				<p class="erreur">Aucun produit enregistré.</p>
			</c:when>
			<%-- Sinon, affichage du tableau. --%>
			<c:otherwise>
				<div id="conteneur_Tableau">

					<c:forEach items="${produit}" var="produit" varStatus="boucle">
						<form method="post"
							action="<c:url value="/listProductCommandeServlet"/>">
						
							<table>
								<tr>

									<th>Code du Produit</th>
									<th>Photo</th>
									<th width="200px">Nom du produit</th>
									<th>Quantité en Stock</th>
									<th>Prix de Vente</th>
									<th>Qté</th>
							</tr>
							<tr>
								
								<td> <c:out value="${produit.productCode}"/></td>
								<td><img src="inc/images/Products/${produit.productCode}.jpg"
									width="80" height="80"></td>
								<td><h2> <c:out value="${ produit.productName }"/></h2></td>
								<td> <c:out value="${produit.quantityInStock}"/></td>
								<td> <c:out value="${produit.msrp}"/>€</td>
								<td> <input type="number" name="quantite" value="1" size="2" min="1"></td>
							
							</tr>
							
							</table>

							<input type="hidden" name="designation"
								value="${produit.productName}" /> <input type="hidden"
								name="codeProduit" value="${produit.productCode}" /> <input
								type="hidden" name="prix" value="${produit.msrp}" /> <input
								type="hidden" name="productline" value="${produit.productLine }" />
					
							<input type="submit" value="Ajouter au Panier" />
						</form>
					</c:forEach>


				</div>


			</c:otherwise>
		</c:choose>
	
	<h2>Votre Panier</h2>

	<%@ include file="listPanier.jsp"%>


</body>
</html>