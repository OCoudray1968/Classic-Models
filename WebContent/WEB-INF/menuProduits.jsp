<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
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
					<h1>Gestion des produits</h1>
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
			
			<li><a href="<c:url value="/officeServlet"/>">Agences</a></li>
			<li><a href="<c:url value="/employeeServlet"/>">Employés</a></li>
			<li><a href="<c:url value="/clientServlet"/>">Clients</a></li>
			<li><a href="<c:url value="/produitServlet"/>">Produits</a></li>
			<li></li>
			<li><a href="<c:url value="/registrationServlet"/>">Inscriptions</a></li>
			<li></li>
			<li><a href="<c:url value="/deconnexionServlet" />">Déconnexion</a></li>
		
			

		</ul>
	</nav>
	</div>

<div id="banniere_menu">
		<p>
			<a href="<c:url value="/listeProduitsServlet"/>">Voir les produits existants</a>
		</p>
		<p>
			<a href="<c:url value="/createProductServlet"/>">Créer un nouveau produit</a>
		</p>
		<p>
			<a href="<c:url value="/updateProductServlet"/>">Modifier un produit existant</a>
		</p>
		<p>
			<a href="<c:url value="/deleteProductServlet"/>">Supprimer un produit existant</a>
		</p>
		
		
	</div>
</body>
</html>