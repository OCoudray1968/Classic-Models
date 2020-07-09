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
					<h1>Suppression employés</h1>
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
		<c:when test="${ empty sessionScope.employees }">
			<p class="erreur">Aucun employé enregistré.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
		<form method="post" action="<c:url value="/validateDeleteEmployeeServlet" />">
				N° Employé : <c:out value="${employees.employeeNumber}"/> 
				<input type="hidden" value="${employees.employeeNumber}" name="EmployeeNumber"/>
				<br><br><br>
				Prénom  : <c:out value="${ employees.firstName }" />
				Nom  :<c:out value="${ employees.lastName }" />
				<br><br>
				Extension  :<c:out value="${ employees.extension }" />
				<br><br>
				Email   :<c:out value="${ employees.email }"/>
				<br>
				Code Agence   :<c:out value="${ employees.officeCode}" />		
				<br>
				
				Reporte à :<c:out value="${ employees.reportsTo }" />	
				Poste :<c:out value="${ employees.jobTitle }"/>
				
				<br><br>
				<input type= "submit" value="Valider Suppression"/>	
			</form>			
										
	
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>