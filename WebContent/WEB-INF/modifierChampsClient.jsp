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
		<%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
		<c:when test="${ empty sessionScope.clients }">
			<p class="erreur">Aucun client enregistré.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
		<form method="post" action="<c:url value="/validateUpdateCustomersServlet" />">
				<label for="customernumber">N° CLIENT :</label><c:out value="${clients.customerNumber}"/> 
				<input type="hidden" value="${clients.customerNumber}" name="customernumber"/>
				<br/><br/>
				<label for="customername">SOCIETE :</label><input type="text" value="${clients.customerName}" name="customername"/>
				<br/><br/>
				<label for="contactlastname">Nom Contact :</label><input type="text" value="${ clients.contactLastName }" name="contactlastname"/>
				<br/><br/>
				<label for="contactfirstname">Prénom Contact :</label><input type="text" value="${ clients.contactFirstName }" name="contactfirstname"/>
				<br/><br/>
				<label for="phone">Téléphone :</label><input type="text" value="${ clients.phone }" name="phone"/>
				<br/><br>
				<label for="addressline1">Adresse 1 :</label><input type="text" value="${ clients.addressLine1 }" name="addressline1"/>
				<br/><br>
				<label for="addressline2">Adresse 2 :</label><input type="text" value="${ clients.addressLine2 }" name="addressline2"/>		
				<br/><br>
				<label for="postalcode">Code Postal :</label><input type="text" value="${ clients.postalCode }" name="postalcode"/>
				Ville :<input type="text" value="${ clients.city }" name="city"/>
				<br/><br>
				<label for="state">Etat :</label><input type="text" value="${ clients.state }"name="state" />	
				Pays :<input type="text" value="${ clients.country }" name="country"/>
				<br/><br/>
				<label for="salesrep">N° commercial :</label><input type ="number" value="${ clients.salesRepEmployeeNumber }" name="salesrep"/>		
				<br/><br>
				<label for="creditlimit">Limite de Crédit :</label><input type ="number" value="${ clients.creditLimit }" name="creditlimit"/>
				<br/><br/>
				<input type= "submit" value="Valider"/>	
			</form>			
										
	
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>