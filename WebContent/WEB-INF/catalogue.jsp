<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<title>Catalogue des produits</title>
<!--  appel du fichier css -->
<link type="text/css" rel="stylesheet"

	href="<c:url value="/inc/css/main.css"/>" />
</head>
<header>
	<div id="titre_principal">
		<div id="logo">
			<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
			<h1>Catalogue</h1>
		</div>

	</div>
<!-- Menu principal de la page catalogue -->
	<nav>
		<ul>
			<li><a href="<c:url value="/connexionServlet"/>">Connexion</a></li>
			<li><a href="<c:url value="/inscriptionServlet" />">Inscription</a></li>
			<li><a href="<c:url value="inc/index.jsp"/>"><img src="inc/images/accueil.png" alt="Logo d'accueil" width=20 height=20/></a></li>

		</ul>
	</nav>
</header>

	<!-- affichage des icones des categories produits -->
	<div id="contact" >
		
		
		<a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Classic Cars" /></c:url>">
				<img src="inc/images/ProductLine/Classic Cars.png"
				alt="Logo de Classic Models" />
				
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Motorcycles" /></c:url>">
				<img src="inc/images/ProductLine/Motorcycles.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Vintage Cars" /></c:url>">
				<img src="inc/images/ProductLine/Vintage Cars.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Planes" /></c:url>">
				<img src="inc/images/ProductLine/Planes.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Ships" /></c:url>">
				<img src="inc/images/ProductLine/Ships.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Trains" /></c:url>">
				<img src="inc/images/ProductLine/Trains.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Trucks and Buses" /></c:url>">
				<img src="inc/images/ProductLine/Trucks and Buses.png"
				alt="Logo de Classic Models" />
			</a>
			</div>

<!--  affichage des vignettes des produits -->
<body>

	<div id="corps">
		<c:choose>
			<%-- Si aucune commande n'existe en session, affichage d'un message par défaut. --%>
			<c:when test="${ empty produit }">
				<p class="erreur">Aucun produit enregistré.</p>
			</c:when>
			<%-- Sinon, affichage du tableau. --%>
			<c:otherwise>
				<div id="conteneurCatalogue">

					<c:forEach items="${produit}" var="produit" varStatus="boucle">
					
							<div id="conteneurImage">
								<img src="inc/images/Products/${produit.productCode}.jpg" width=200 height=200><br>
								<h1>${ produit.productName }</h1>
								<p>Ref du produit: ${produit.productCode}</p>
						<%-- 		<p>${produit.productDescription }</p>--%>
								<h2>Quantité en Stock: ${produit.quantityInStock}</h2>
								<h2>Prix de Vente: ${produit.msrp} €</h2>
							
								
								
							</div>
					
					</c:forEach>
				</div>


			</c:otherwise>
		</c:choose>
	</div>
	
</body>
  <script src="js/main.js"  ></script>
</html>