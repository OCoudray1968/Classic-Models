<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste détail des commandes </title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>

<body>

	<div id="corps">
	
	
		<c:choose>
			<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
			<c:when test="${ empty sessionScope.detailcommandes }">
				<p class="erreur"></p>
			</c:when>
			<%-- Sinon, affichage du tableau. --%>
		
			<c:otherwise>
				<table>
					<tr>
										
						<th>Code Produit</th>
						<th>Photo Article</th>
						<th>Quantité</th>
						<th>Prix</th>
						<th>Total Article</th>
												
					</tr>
					
					<%-- Parcours de la Map des commandes en session, et utilisation de l'objet varStatus. --%>
					<c:forEach items="${ sessionScope.detailcommandes }" var="detailcommandes"
						varStatus="boucle">
						
						<%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
						<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
						
							<%-- Affichage des propriétés du bean Commande, qui est stocké en tant que valeur de l'entrée courante de la map --%>
							
							<td><c:out value="${detailcommandes.productCode }" /></td>
							<td><img src="inc/images/Products/${detailcommandes.productCode}.jpg"
									width="80" height="80"></td>
							<td><c:out value="${ detailcommandes.quantityOrdered }" /></td>
							<td><c:out value="${ detailcommandes.priceEach}" /></td>
							<td><c:out value="${detailcommandes.quantityOrdered*detailcommandes.priceEach }" /></td>
							
							<%-- Lien vers la servlet de suppression, avec passage de la date de la commande - c'est-à-dire la clé de la Map - en paramètre grâce à la balise <c:param/>. --%>
							
						</tr>
						
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
	
	</div>
</body>
</html>