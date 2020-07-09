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
					<h1>Création d'un client</h1>
					<br>
				</div>

			</div>

			<p>
				<c:out
					value="${employee.firstName} ${employee.lastName }: ${employee.jobTitle}" />
			
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
	
		<form method="post" action="<c:url value="/createCustomersServlet" />">
				
				<label for="customername">SOCIETE : </label><input type="text"  name="customername"/>
				<br/><br/>
				<label for="contatclastname">Nom Contact :</label><input type="text"name="contactlastname"/>
				<br/>
				<label for="contactfirstname">Prenom Contact :</label><input type="text"  name="contactfirstname"/>
				<br/><br/>
				<label for="phone">Téléphone :</label><input type="text" name="phone"/>
				<br/><br>
				<label for="addressline1">Adresse 1 :</label><input type="text" name="addressline1"/>
				<br/>
				<label for="addressline2">Adresse 2 :</label><input type="text" name="addressline2"/>		
				<br/>
				<label for="postalcode">Code Postal :</label><input type="text"  name="postalcode"/>	
				Ville :<input type="text"  name="city"/>
				<br/>
				<label for="state">Etat :</label><input type="text" name="state" />	
				Pays :<input type="text"  name="country"/>
				<br/><br/>
				<label for="salesrep">Numéro Commercial :</label><Select name="salesrep" >
			
							<%-- Parcours de la Map des clients en session, et utilisation de l'objet varStatus. --%>
				<c:forEach items="${ sessionScope.salesrep }" var="employees"
					varStatus="boucle">
			
				 	<%-- Affichage des listes deroulantes Numéro Client, et Nom Client --%>
						<option value="${ employees.employeeNumber }">${employees.employeeNumber}</option>
						
				</c:forEach>
				</Select>		
				<br/><br/>
				<label for="creditlimit">Limite de Crédit :</label>	<input type ="number"  name="creditlimit"/>
				<br><br><br/><br/>
				<label for="login">Login :</label><input type ="Text"  name="login"/>		
				<br/>
				<label for="pwd">Password :</label><input type ="Text"  name="pwd"/>
				<br/><br/>
				
				<input type= "submit" value="Valider"/>	<input type="reset" value="Remettre à zéro"/>
			</form>			
		
	
		
</div>
</body>
</html>