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
	
		<form method="post" action="<c:url value="/createOfficeServlet" />">
			<fieldset>
				<legend>informations</legend>
				<label for="city">Ville :</label><input type="text" name="city" />
				<br><br>
				<label for="phone">Téléphone :</label><input type="text" name="phone" />
				<br><br>
				<label for="addressline1">Adresse 1 :</label><input type="text" name="addressline1" />
				<br><br>
				<label for="addressline2">Adresse 2 :</label><input type="text" name="addressline2"/>
				<br><br>
				<label for="postalcode">Code Postal :</label><input type="text"  name="postalcode"/>
				<br><br>	
				<label for="state">Etat :</label><input type="text" name="state" />		
				<br><br>
				<label for="country">Pays :	</label><input type="text"  name="country"/>
				<br><br>
				<label for="territory">Territoire:</label><input type="text" name="territory" >
				<br>
			</fieldset>
				<br>
				<input type= "submit" value="Valider"/>	<input type="reset" value="Remettre à zéro"/>
			</form>			
		
	
		
</div>
</body>
</html>