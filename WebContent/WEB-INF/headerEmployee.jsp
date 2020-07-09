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
					<h1>Employés</h1>
					<br>
					<br>



				</div>

			</div>

			<p>
				<c:out
					value="${employee.firstName} ${employee.lastName } : ${employee.jobTitle}" />
			
			<img src="inc/images/Employees/${employee.employeeNumber}.jpg"
				width=80px height=80px><br>
			</p>
			<input type="hidden" id="salesRep" name="salesRep" value="${employee.employeeNumber }" />
		</header>
		</div>
		<div id="banniere_menu">
	
	<nav>
		<ul>
			
			<li><a href="<c:url value="/commandeEnCoursServlet"/>">Commandes</a></li>
			<li><a href="<c:url value="/listCustomersServlet"/>">Clients</a></li>
			<li></li>
			<li></li>
			<li><a href="<c:url value="/deconnexionServlet" />">Deconnexion</a></li>

		</ul>
	</nav>
	</div>
	
	
</body>
</html>