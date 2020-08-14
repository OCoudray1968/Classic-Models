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
					<h1>Création d'un produit</h1>
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
	
		<form method="post" action="<c:url value="/createProductServlet" />">
				
				<label for="productcode">Code Produit :</label> <input type="text"  name="productcode"/>
				<br/><br/><br/>
				<label for="productname">Nom Produit :</label> <input type="text"  name="productname"/>
				<br/><br/>
				<label for="productline">Ligne de Produit :</label><Select name="productline" >
			
							<%-- Parcours de la Map des clients en session, et utilisation de l'objet varStatus. --%>
				<c:forEach items="${ sessionScope.productline }" var="productline"
					varStatus="boucle">
			
				 	<%-- Affichage des listes deroulantes Numéro Client, et Nom Client --%>
						<option value="${ productline.productLine}">${productline.productLine}</option>
						
				</c:forEach>
				</Select>
				<br/><br>
				<label for="productscale">Echelle du produit :</label><input type="text"name="productscale"/>
				<br/><br>
				<label for="productvendor">Vendeur :</label><input type="text" name="productvendor"/>
				<br/><br>
				<label for="productdescription">Description  :</label><input type="text" name="productdescription"/>
				<br/><br>
				<label for="quantityinstock">Quantité en Stock  :</label><input type="text" name="quantityinstock"/>		
				<br/><br>
				<label for="buyprice">Prix d'achat :</label><input type="number"  name="buyprice"/>	
				<br/><br>
				<label for="msrp">Prix vente conseillé :</label><input type="number"  name="msrp"/>
				<br/><br/>
				<input type= "submit" value="Valider"/>	<input type="reset" value="Remettre à zéro"/>
			</form>			
		
	
		
</div>
</body>
</html>