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
					<h1>Création d'une agence</h1>
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
	
		<form method="post" action="<c:url value="/validateDeleteOfficeServlet" />">
			<fieldset>
				N° Agence : <c:out value="${offices.officeCode}"/> 
				<input type="hidden" value="${offices.officeCode}" name="officecode"/>
				<br>
				Ville :<c:out value="${ offices.city }"/>
				<br>
				Téléphone   :<c:out value="${ offices.phoneOffice }" />
				<br>
				Adresse 1   :<c:out value="${ offices.addressLine1 }"/>
				<br>
				Adresse 2   :<c:out value="${ offices.addressLine2 }" />		
				<br>
				Code Postal :<c:out value="${ offices.postalCode }" />	
				<br>
				Etat        :	<c:out value="${ offices.stateOffice }" />	
				<br>
				Pays :	<c:out value="${ offices.countryOffice }"/>
				<br>
				Territoire : <c:out value="${ offices.territory }" />		
				</fieldset>
				<br><br>
				<input type= "submit" value="Valider Suppression"/>	
			</form>			
	
</div>
</body>
</html>