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
<header>
	<div id="titre_principal">
		<div id="logo">
			<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
			<h1>Classic Models: </h1>
			<h1>${sessionScope.employee.firstName} ${sessionScope.employee.lastName } </h1>
		</div>

	</div>

	<nav>
		<ul>
			<li><a href="<c:url value="/deconnexionServlet" />">Deconnexion</a></li>
			<li><a href="<c:url value="/dispatchServlet"><c:param name="employeeNumber" value="${sessionScope.employee.employeeNumber}" /></c:url>">Retour</a></li>
			
		
		</ul>
	</nav>
</header>
<body>
		
	<div id="corps">
		<form method="post" action="<c:url value="/validerPrepaCommande" />">
		
		
			<h1><span class="marge">N° Commande : ${numcommande} </span>
  			<span class="marge">Nom Client : ${client.customerName}</span></h1>
	
	
		<c:choose>
			<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
			<c:when test="${ empty sessionScope.detailcommandes }">
				<p class="erreur"></p>
			</c:when>
			
			<%-- Sinon, affichage du tableau. --%>
		
			<c:otherwise>
				
				<table class="tabcenter">
					<tr>
										
						<th>Code Produit</th>
						<th>Photo Article</th>
						<th>Quantité</th>
						<th>Prix</th>
						<th>Total Article</th>
						<th>Validation Ligne</th>
												
					</tr>
					
					<%-- Parcours de la Map des commandes en session, et utilisation de l'objet varStatus. --%>
					<c:forEach items="${ sessionScope.detailcommandes }" var="detailcommandes"
						varStatus="boucle">
						
						<%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
						<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
						
							<%-- Affichage des propriétés du bean Commande, qui est stocké en tant que valeur de l'entrée courante de la map --%>
							
							<td><c:out value="${detailcommandes.productCode }" /></td>
							<td><img src="inc/images/Products/${detailcommandes.productCode}.jpg"
									width="40" height="40"></td>
							<td><c:out value="${ detailcommandes.quantityOrdered }" /></td>
							<td><c:out value="${ detailcommandes.priceEach}" /></td>
							<td><c:out value="${ detailcommandes.quantityOrdered*detailcommandes.priceEach }" /></td>
							<td><input type="checkbox" name="valid[${index}]" value="valid" /></td>
						
						</tr>
						
					</c:forEach>
				</table>
				<br>
				<br>
				<center><input type="submit" value="Valider la commande"/></center>
			
			</c:otherwise>
		</c:choose>
			
		</form> 
	</div>
		
</body>
</html>