<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css"/>" />
<title>Classic Models</title>
</head>
<div id="accueil">
		<header>
			<div id="titre_principal">
				<div id="logo">
					<img src="images/logoCM.png" alt="Logo de Classic Models" />
					<h1>Classic Models</h1>
				</div>

			</div>

			<nav>
				<ul>
					<li><a href="<c:url value="/connexionServlet" />">Connexion</a></li>
					<li><a href="<c:url value="/inscriptionServlet" />">Inscription</a></li>
			

				</ul>
			</nav>
		</header>
		</div>
<body>
	
	<div id="contact" >
		
		
		<a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Classic Cars" /></c:url>">
				<img src="images/ProductLine/Classic Cars.png"
				alt="Logo de Classic Models" />
				
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Motorcycles" /></c:url>">
				<img src="images/ProductLine/Motorcycles.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Vintage Cars" /></c:url>">
				<img src="images/ProductLine/Vintage Cars.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Planes" /></c:url>">
				<img src="images/ProductLine/Planes.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Ships" /></c:url>">
				<img src="images/ProductLine/Ships.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Trains" /></c:url>">
				<img src="images/ProductLine/Trains.png"
				alt="Logo de Classic Models" />
			</a> <a
				id="photo_min" href="<c:url value="/listProductServlet"><c:param name="productline" value="Trucks and Buses" /></c:url>">
				<img src="images/ProductLine/Trucks and Buses.png"
				alt="Logo de Classic Models" />
			</a>
			</div>
		 <section>
			<article>
		
			<div class="d1"></div>
			<div class="conteneurDiapo"></div>
			<div class="d2"></div>
	
		</article>
	
			<aside>
				<h1>Informations</h1>
				<img src="images/bulle.png" alt="" id="fleche_bulle" />
				<ul>
				<li>	Notre société leader dans la vente de  Modèles réduits de qualités vous propose un choix multiple d'une très grande précision
				de reproduction.</li>
				<li><img src="images/logoCM.png" alt="logo classic model" width=200 height=200 align="bottom"/></li>
				</ul>
				
			</aside>
		</section> 

		<footer>
		<div class="contact">
		<nav>
				<ul>
					<li><a href="<c:url value="/connexionServlet" />">Conditions Générales de Vente</a></li>
					<li><a href="<c:url value="/inscriptionServlet" />">Service Client</a></li>
					<li><a href="<c:url value="/monCompte" />">Mon compte</a></li>
			

				</ul>
			</nav>
		</div>

		</footer>
	
</body>

