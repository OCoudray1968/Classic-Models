<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Liste des commandes à traiter</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>

		<header>
			<div id="titre_principal">

				<div id="logo">
					<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
					<h1> Commande à traiter</h1>
									
				</div>

			</div>

			<p>
				<c:out
					value="${employee.firstName} ${employee.lastName } : ${employee.jobTitle}" />
			
			<img src="inc/images/Employees/${employee.employeeNumber}.jpg"
				width=80px height=80px><br>
			</p>
			<input type="hidden" id="salesRep" name="salesRep" value="${employee.employeeNumber }" />
		</header>
	
		<div id="banniere_menu">
	
	<nav>
		<ul>
			
			<li><a href="<c:url value="/commandeEnCoursServlet"/>">Commandes</a></li>
			<li><a href="<c:url value="/listCustomersServlet"/>">Clients</a></li>
			<li></li>
			<li></li>
			<li><a href="<c:url value="/deconnexionServlet" />">Deconnexion</a></li>
		</ul>
	</nav>
	</div>
<body>

	<div id="corps">
		<div id="conteneur">
	
		<c:choose>
			<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
			<c:when test="${ empty sessionScope.commandes }">
				<p class="erreur">Aucune commande enregistrée.</p>
			</c:when>
		
			<%-- Sinon, affichage du tableau. --%>
			<c:otherwise>
			
				<table>
					<tr>
						
						<th>Numero de Commande</th>
						<th>Numéro de Client</th>
						<th>Date Commande</th>
						<th>Date livraison demandée</th>
						<th>Date livraison</th>
						<th>Statut de la commande</th>
						<th>commentaires</th>
						
						
					</tr>
					
					<%-- Parcours de la Map des commandes en session, et utilisation de l'objet varStatus. --%>
					<c:forEach items="${ sessionScope.commandes }" var="commandes"
						varStatus="boucle">
						
						<%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
						<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
						
							<%-- Affichage des propriétés du bean Commande, qui est stocké en tant que valeur de l'entrée courante de la map --%>
							
							<td><a
							 href="<c:url value="/detailCommandesEnCours"><c:param name="orderNumber" value="${commandes.orderNumber}" 
							 		/><c:param name="customerNumber" value="${commandes.customerNumber}"/></c:url>">${commandes.orderNumber}</a></td>
			
			<%-- Sinon, affichage du tableau. --%>
							<td><c:out value="${ commandes.customerNumber }"/></td>
							<td><c:out value="${ commandes.orderDate }" /></td>
							<td><c:out value="${ commandes.requiredDate }" /></td>
							<td><c:out value="${ commandes.shippedDate }" /></td>
							<td><c:out value="${ commandes.statusOrder }" /></td>
							<td><c:out value="${ commandes.comments }" /></td>
							
							
							<%-- Lien vers la servlet de suppression, avec passage de la date de la commande - c'est-à-dire la clé de la Map - en paramètre grâce à la balise <c:param/>. --%>
							
						</tr>
						
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>
		</div>
	
	</div>
</body>
</html>