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
					<h1>Suppression Produit</h1>
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
		<c:when test="${ empty sessionScope.produits }">
			<p class="erreur">Aucun produit enregistré.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
		<form method="post" action="<c:url value="/validateDeleteProductServlet" />">
				<img src="inc/images/Products/${produits.productCode}.jpg"
				width=100px height=100px><br>
			<input type="hidden" id="salesRep" name="salesRep" value="${produits.productCode }" />
				
				Code Produit: <c:out value="${produits.productCode}"/> 
				<input type="hidden" value="${produits.productCode}" name="productcode"/>
				Nom du produit: <c:out value="${produits.productName}" />
				<br><br><br>
				Ligne de Produit : <c:out value="${ produits.productLine }" />
				<br>
				Echelle :<c:out value="${ produits.productScale }" />
				<br><br>
				Vendeur  :<c:out value="${ produits.productVendor }" />
				<br><br>
				Description  :<c:out value="${ produits.productDescription }"/>
				<br>
				Quantité en Stock  :<c:out value="${ produits.productDescription}" />		
				<br>
				
				Prix d'achat :<c:out value="${ produits.buyPrice}" />	
				
				<br>
				Prix de vente conseillé    :<c:out value="${ produits.msrp}" />	
				
				<br><br>
				<input type= "submit" value="Valider Suppression"/>	
			</form>			
										
	
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>