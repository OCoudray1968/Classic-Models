
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Liste des commandes existantes</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
</head>
<header>
	<div id="titre_principal">
		<div id="logo">
			<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
			<h1>Liste des clients</h1>
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
			<li><a href="<c:url value="/registrationServlet"/>">Inscriptions</a></li>
			<li></li>
			<li><a href="<c:url value="/deconnexionServlet" />">Déconnexion</a></li>
		
			

		</ul>
	</nav>
	</div>

<div id="corps">
	<c:choose>
		<%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
		<c:when test="${ empty sessionScope.clients }">
			<p class="erreur">Aucun client enregistré.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
			<table>
				<tr>
					<th>Num Client</th>
					<th>Nom Client</th>
					<th>Nom contact</th>
					<th>Prénom contact</th>
					<th>Téléphone</th>
					<th>Adresse 1</th>
					<th>Adresse 2</th>
					<th>Ville</th>
					<th>Etat</th>
					<th>Code Postal</th>
					<th>Pays</th>
					<th>Comm</th>
					<th>Limite de Crédit</th>

				</tr>
				<%-- Parcours de la Map des clients en session --%>
				<c:forEach items="${ sessionScope.clients }" var="clients"
					varStatus="boucle">
					<%-- Simple test de parité sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
					<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
						<%-- Affichage des propriétés du bean Client, qui est stocké en tant que valeur de l'entrée courante de la map --%>
						<td><c:out value="${ clients.customerNumber }" /></td>
						<td><c:out value="${ clients.customerName }" /></td>
						<td><c:out value="${ clients.contactFirstName }" /></td>
						<td><c:out value="${ clients.contactLastName }" /></td>
						<td><c:out value="${ clients.phone }" /></td>
						<td><c:out value="${ clients.addressLine1 }" /></td>
						<td><c:out value="${ clients.addressLine2 }" /></td>
						<td><c:out value="${ clients.city }" /></td>
						<td><c:out value="${ clients.postalCode }" /></td>
						<td><c:out value="${ clients.state }" /></td>
						<td><c:out value="${ clients.country }" /></td>
						<td><c:out value="${ clients.salesRepEmployeeNumber }" /></td>
						<td><c:out value="${ clients.creditLimit }" /></td>

						
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>