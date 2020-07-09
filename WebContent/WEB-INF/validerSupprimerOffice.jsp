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
					<h1> Suppression Agence</h1>
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
	
		<form method="post" action="<c:url value="/validateDeleteOfficeServlet" />">
				N° Agence : <c:out value="${offices.officeCode}"/> 
				<input type="hidden" value="${offices.officeCode}" name="officecode"/>
				<br><br>
				Ville :<c:out value="${ offices.city }"/>
				<br><br>
				Téléphone   :<c:out value="${ offices.phoneOffice }" />
				<br><br>
				Adresse 1   :<c:out value="${ offices.addressLine1 }"/>
				<br>
				Adresse 2   :<c:out value="${ offices.addressLine2 }" />		
				<br>
				Code Postal :<c:out value="${ offices.postalCode }" />	
				
				<br>
				Etat        :	<c:out value="${ offices.stateOffice }" />	
				Pays :	<c:out value="${ offices.countryOffice }"/>
				<br><br>
				Territoire : <c:out value="${ offices.territory }" />		
				
				<br><br>
				<input type= "submit" value="Valider Suppression"/>	
			</form>			
	
</div>
</body>
</html>