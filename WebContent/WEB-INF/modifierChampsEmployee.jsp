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
					<h1>Modification employé</h1>
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
	
		<form method="post" action="<c:url value="/validateUpdateEmployeeServlet" />">
			<fieldset>
				<label for="employeenumber">N° Employé :</label><c:out value="${employees.employeeNumber}"/> 
				<input type="hidden" value="${employees.employeeNumber}" name="employeenumber"/>
				<br><br>
				<label for="lastname">Nom :</label><input type="text" value="${ employees.lastName }" name="lastname"/>
				<br><br>
				<label for="lastname">Prénom :</label><input type="text" value="${ employees.firstName }" name="firstname"/>
				<br><br/>
				<label for="extension">Extension :</label><input type="text" value="${ employees.extension }" name="extension"/>
				<br><br>
				<label for="email">Email :</label><input type="text" value="${ employees.email }" name="email"/>
				<br><br>
				<label for="officecode">Code Agence :</label><input type="text" value="${ employees.officeCode }" name="officecode"/>		
				<br><br>
				<label for="reportsto">Reporte à :</label><input type="text" value="${ employees.reportsTo }" name="reportsto"/>
				<br><br>	
				<label for="jobtitle">Poste :</label><input type="text" value="${ employees.jobTitle }" name="jobtitle"/>
			</fieldset>
				<br><br>
				<input type= "submit" value="Valider"/>	
			</form>			
	
</div>
</body>
</html>