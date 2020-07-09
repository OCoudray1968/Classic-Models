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
					<h1>Inscription Client</h1>
					<br>
					<br>


				</div>

			</div>

			<p>
				<c:out
					value="${employee.firstName} ${employee.lastName } : ${employee.jobTitle}" />
			
			
			<img src="inc/images/Employees/${employee.employeeNumber}.jpg"
				 alt="Photo de l'employé" width=70px height=80px >
			
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
	
		<form method="post" action="<c:url value="/validateRegistrationServlet" />">
				
				
				<label for="customername">SOCIETE :</label><input type="text" value="${registrations.customerName}" name="customername"/>
				<br/><br/>
				<label for="contactlastname">Nom Contact :</label><input type="text" value="${ registrations.contactLastName }" name="contactlastname"/>
				<br/>
				<label for="contactfirstname">Prénom Contact :</label><input type="text" value="${ registrations.contactFirstName }" name="contactfirstname"/>
				<br/><br/>
				<label for="phone">Téléphone :</label><input type="text" value="${ registrations.phone }" name="phone"/>
				<br/>
				<label for="addressline1">Adresse 1 :</label><input type="text" value="${registrations.addressLine1 }" name="addressline1"/>
				<br/>
				<label for="addressline2">Adresse 2 :</label><input type="text" value="${registrations.addressLine2 }" name="addressline2"/>		
				<br/>
				<label for="postalcode">Code Postal :</label><input type="text" value="${ registrations.postalCode }" name="postalcode"/>
				Ville :<input type="text" value="${ registrations.city }" name="city"/>
				<br/>
				<label for="state">Etat :</label><input type="text" value="${registrations.state }"name="state" />	
				Pays :<input type="text" value="${ registrations.country }" name="country"/>
				<br/><br/>
				<label for="salesrep">N° commercial :</label><input type ="number" value="" name="salesrep"/>		
				<br/>
				<label for="creditlimit">Limite de Crédit :</label><input type ="number" value="" name="creditlimit"/>
				<br/><br/>
				<label for="login">Login :</label><input type ="Text" value="${ registrations.login }" name="login"/>		
				<br/>
				<label for="pwd">Password :</label><input type ="Text" value="${ registrations.pwd }" name="pwd"/>
				<br/><br/>
				
				
				<input type= "submit" value="Valider"/>	
			</form>			
		
	
		
</div>
</body>
</html>