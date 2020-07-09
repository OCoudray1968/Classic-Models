<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Liste des produits existants</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>
<header>
	<div id="titre_principal">
		<div id="logo">
			<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
			<h1>Liste des produits</h1>
		</div>

	</div>
		<p>
					<c:out
					value="${employee.firstName} ${employee.lastName } : ${employee.jobTitle}" />
			
			<img src="inc/images/Employees/${employee.employeeNumber}.jpg"
				width=70px height=80px><br>
			</p>
			<input type="hidden" id="salesRep" name="salesRep" value="${employee.employeeNumber }" />
		</header>
	
	<div id="banniere_option">
	
	<nav>
		<ul>
			
			<li><a href="<c:url value="/officeServlet"/>">Offices</a></li>
			<li><a href="<c:url value="/employeeServlet"/>">Employés</a></li>
			<li><a href="<c:url value="/clientServlet"/>">Clients</a></li>
			<li><a href="<c:url value="/produitServlet"/>">Produits</a></li>
			<li></li>
			<li></li>
			<li><a href="<c:url value="/deconnexionServlet" />">Déconnexion</a></li>
		
			

		</ul>
	</nav>
	</div>

<div id="corps">
	<c:choose>
		<%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
		<c:when test="${ empty sessionScope.produits }">
			<p class="erreur">Aucun produit enregistré.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
			<table>
				<tr>
					<th>Code Produit</th>
					<th>Photo</th>
					<th>Nom Produit</th>
					<th>Ligne de Produit</th>
					<th>Echelle</th>
					<th>Vendeur</th>
					<th>Description</th>
					<th>Qté en Stock</th>
					<th>Prix d'achat</th>
					<th>Prix vente conseillé</th>
					

				</tr>
				<%-- Parcours de la Map des clients en session, et utilisation de l'objet varStatus. --%>
				<c:forEach items="${ sessionScope.produits }" var="produits"
					varStatus="boucle">
					<%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
					<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
						<%-- Affichage des propriétés du bean Client, qui est stocké en tant que valeur de l'entrée courante de la map --%>
						<td><c:out value="${ produits.productCode }" /></td>
						<td><img src="inc/images/Products/${produits.productCode}.jpg" width=100 height=100><br></td>
						<td><c:out value="${ produits.productName }" /></td>
						<td><c:out value="${ produits.productLine}" /></td>
						<td><c:out value="${ produits.productScale }" /></td>
						<td><c:out value="${ produits.productVendor }" /></td>
						<td><c:out value="${ produits.productDescription}" /></td>
						<td><c:out value="${ produits.quantityInStock }" /></td>
						<td><c:out value="${ produits.buyPrice}" /></td>
						<td><c:out value="${ produits.msrp }" /></td>
						
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>