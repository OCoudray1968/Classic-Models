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
			<h1>Liste des employ�s</h1>
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
			<li><a href="<c:url value="/employeeServlet"/>">Employ�s</a></li>
			<li><a href="<c:url value="/clientServlet"/>">Clients</a></li>
			<li><a href="<c:url value="/produitServlet"/>">Produits</a></li>
			<li></li>
			<li><a href="<c:url value="/registrationServlet"/>">Inscriptions</a></li>
			<li></li>
			<li><a href="<c:url value="/deconnexionServlet" />">D�connexion</a></li>
		
			

		</ul>
	</nav>
	</div>

<div id="banniere_image">
	
</div>

<div id="corps">
	<c:choose>
		<%-- Si aucun client n'existe en session, affichage d'un message par d�faut. --%>
		<c:when test="${ empty sessionScope.employees }">
			<p class="erreur">Aucun client enregistr�.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
			<table>
				<tr>
					<th>Num�ro Employ�e</th>
					<th>Nom Employ�</th>
					<th>Pr�nom Employ�</th>
					<th>Extension</th>
					<th>Email</th>
					<th>Code Agence</th>
					<th>Reporte �</th>
					<th>Poste</th>
				
				
				</tr>
				<%-- Parcours de la Map des clients en session, et utilisation de l'objet varStatus. --%>
				<c:forEach items="${ sessionScope.employees }" var="employees"
					varStatus="boucle">
					<%-- Simple test de parit� sur l'index de parcours, pour alterner la couleur de fond de chaque ligne du tableau. --%>
					<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair'}">
						<%-- Affichage des propri�t�s du bean Client, qui est stock� en tant que valeur de l'entr�e courante de la map --%>
						<td><c:out value="${ employees.employeeNumber }" /></td>
						<td><c:out value="${ employees.lastName}" /></td>
						<td><c:out value="${ employees.firstName }" /></td>
						<td><c:out value="${ employees.extension }" /></td>
						<td><c:out value="${ employees.email }" /></td>
						<td><c:out value="${ employees.officeCode }" /></td>
						<td><c:out value="${ employees.reportsTo }" /></td>
						<td><c:out value="${ employees.jobTitle }" /></td>
						

					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>