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
					<h1>Création d'un employé</h1>
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
	
		<form method="post" action="<c:url value="/createEmployeeServlet" />">
		<fieldset>
			<legend>Informations employé</legend>
				<label for="lastname">Nom  :</label><input type="text"name="lastname"/>
				<br/>
				<label for="firstname">Prénom : </label><input type="text"  name="firstname"/>
				<br/><br/>
				<label for="extension">Extension :</label><input type="text" name="extension"/>
				<br/>
				<label for="email">Email :</label><input type="text" name="email"/>
				<br/><br/>
				<label for="officecode">Code Agence :</label><select name="officecode">
			
							<%-- Parcours de la Map des clients en session, et utilisation de l'objet varStatus. --%>
				<c:forEach items="${ sessionScope.offices }" var="offices"
					varStatus="boucle">
			
				 	<%-- Affichage des listes deroulantes Numéro Agence --%>
						<option value="${ offices.officeCode }">${offices.officeCode}  ${offices.city} </option>
						
				</c:forEach>
				</Select>	
				<br/><br/>
				<label for="reportsto">Reporte à :</label><select name="reportsto">
			
							<%-- Parcours de la Map des clients en session, et utilisation de l'objet varStatus. --%>
				<c:forEach items="${ sessionScope.reportsto }" var="employees"
					varStatus="boucle">
			
				 	<%-- Affichage des listes deroulantes Numéro Client, et Nom Client --%>
						<option value="${ employees.employeeNumber }">${employees.employeeNumber}  ${employees.lastName}</option>
						
				</c:forEach>
				</Select>	
				<br/><br/>	
				<label for="jobtitle">Poste :</label><input type="text"  name="jobtitle"/>
			</fieldset>
			<fieldset>
				<legend>Connexion</legend>
				<label for="login">Login :</label><input type="text" name="login" />	
				<br/>
				<label for="pwd">Password :</label><input type="text" name="pwd"/>
				<br/>
				<label for="profil">Profil :</label><input type="text" name="profil"/>
			</fieldset>
				<br/><br/>
								
				<input type= "submit" value="Valider"/>	<input type="reset" value="Remettre à zéro"/>
			</form>			
		
	
		
</div>
</body>
</html>