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
					<h1>Modification produits</h1>
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
	<c:choose>
		<%-- Si aucun produit n'existe en session, affichage d'un message par défaut. --%>
		<c:when test="${ empty sessionScope.produits }">
			<p class="erreur">Aucun produit enregistré.</p>
		</c:when>
		<%-- Sinon, affichage du tableau. --%>
		<c:otherwise>
		<form method="post" action="<c:url value="/validateUpdateProductServlet" />">
				<img src="inc/images/Products/${produits.productCode}.jpg"
				width=100px height=100px>
				<br/><br/>
				
				<label for="productcode">Code Produit :</label><c:out value="${produits.productCode}"/> 
				<input type="hidden" value="${produits.productCode}" name="productcode"/>
				<br/><br/>
				<label for="productname">Nom du produit :</label><input type="text" value="${produits.productName}" name="productname"/>
				<br/>
				<label for="productline">Ligne de produit :</label><input type="text" value="${ produits.productLine }" name="productline"/>
				<br/>
				<label for="productscale">Echelle :</label><input type="text" value="${ produits.productScale }" name="productscale"/>
				<br/>
				<label for="productvendor">Vendeur :</label><input type="text" value="${ produits.productVendor }" name="productvendor"/>
				<br/>
				<label for="productdescription">Description :</label><input type="text" value="${produits.productDescription}" name="productdescription"/>
				<br>
				<label for="quantityinstock">Quantité en Stock :</label><input type="text" value="${ produits.quantityInStock }" name="quantityinstock"/>		
				<br/>
				<label for="buyprice">Prix d'achat :</label><input type="text" value="${ produits.buyPrice}" name="buyprice"/>	
				<br/>
				<label for="msrp">Prix de vente conseillé :</label><input type="text" value="${ produits.msrp}" name="msrp"/>
							
				<br/><br/>
				<input type= "submit" value="Valider"/>	
			</form>			
										
	
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>