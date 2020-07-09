<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
<title>Classic Models</title>
</head>
<body>
	<div id="accueil">
		<header>
			<div id="titre_principal">

				<div id="logo">
					<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
					<h1>Modification clients</h1>
					<br>



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
	</div>
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
		<%-- Si aucune office n'existe en session, affichage d'un message par défaut. --%>
		<c:when test="${ empty sessionScope.offices }">
			<p class="erreur">Aucune agence enregistrée.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
		<form method="post" action="<c:url value="/updateOfficeServlet" />">
			Numéro Agence :<Select name="OfficeCode" >
			
							<%-- Parcours de la table office --%>
				<c:forEach items="${ sessionScope.offices }" var="offices"
					varStatus="boucle">
			
				 	<%-- Affichage des listes deroulantes Numéro Office, et Nom Office--%>
						<option value="${ offices.officeCode }"> ${offices.city}</option>
						
				</c:forEach>
				</Select>
				<input type="submit" value="valider"/>
				
		</form>		
							
	
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>