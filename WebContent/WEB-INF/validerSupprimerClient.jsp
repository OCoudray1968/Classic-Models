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
					<h1>Suppression clients</h1>
					<br>



				</div>

			</div>

			<p>
				<c:out
					value="${employee.firstName} ${employee.lastName } : ${employee.jobTitle}" />
			</p>
			<img src="inc/images/Employees/${employee.employeeNumber}.jpg"
				width=80px height=80px><br>
			<input type="hidden" id="salesRep" name="salesRep" value="${employee.employeeNumber }" />
		</header>
</div>

<div id="corps">
	<c:choose>
		<%-- Si aucun client n'existe en session, affichage d'un message par défaut. --%>
		<c:when test="${ empty sessionScope.clients }">
			<p class="erreur">Aucun client enregistré.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
		<form method="post" action="<c:url value="/validateDeleteCustomerServlet" />">
				N° CLIENT : <c:out value="${clients.customerNumber}"/> 
				<input type="hidden" value="${clients.customerNumber}" name="CustomerNumber"/>
				SOCIETE : <c:out value="${clients.customerName}" />
				<br><br><br>
				Prenom Contact : <c:out value="${ clients.contactFirstName }" />
				Nom Contact :<c:out value="${ clients.contactLastName }" />
				<br><br>
				Téléphone   :<c:out value="${ clients.phone }" />
				<br><br>
				Adresse 1   :<c:out value="${ clients.addressLine1 }"/>
				<br>
				Adresse 2   :<c:out value="${ clients.addressLine2 }" />		
				<br>
				
				Code Postal :<c:out value="${ clients.postalCode }" />	
				Ville :<c:out value="${ clients.city }"/>
				<br>
				Etat        :	<c:out value="${ clients.state }" />	
				Pays :	<c:out value="${ clients.country }"/>
				<br><br>
				N° commercial : <c:out value="${ clients.salesRepEmployeeNumber }" />		
				<br><br>
				Limite de Crédit :	<c:out value="${ clients.creditLimit }"/>
				<br><br>
				<input type= "submit" value="Valider Suppression"/>	
			</form>			
										
	
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>