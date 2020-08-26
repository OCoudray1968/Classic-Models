<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<head>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/css/main.css"/>" />
<title>Classic Models</title>
</head>
<body>
	<c:set var="today" value="<%=new java.util.Date()%>" />
	<div id="accueil">
		<header>
			<div id="titre_principal">

				<div id="logo">
					<img src="inc/images/logoCM.png" alt="Logo de Classic Models" />
					<h1>Validation Commande</h1>
					<br>
			
				</div>

			</div>
			<p>
				Bienvenue :
					<c:out
						value="${sessionScope.client.contactFirstName} ${client.contactLastName}" />
			<img src="inc/images/Customers/${client.contactFirstName} ${client.contactLastName}.jpg"
					width=80px height=80px><br>
			
			</p>
		
			</header>
		<div id="banniere_option">
	
	<nav>
		<ul>
			
			<li><a href="<c:url value="/listeCommandesServlet"/>">Historique</a></li>
			<li><a href="<c:url value="/categorieCommandeServlet"/>">Commander</a></li>
			<li></li>
			<li></li>
			<li><a href="<c:url value="/deconnexionServlet" />">Déconnexion</a></li>
		
			

		</ul>
	</nav>
	</div>

	
	</div>
	
		
			<section>
				<article>



					<h1>
						<img src="inc/images/ico_epingle.png" alt="Catégorie"
							class="ico_categorie" />${sessionScope.client.customerName }</h1>
							<a href="<c:url value="/pdfexport"/>">Commande en PDF</a>
					<h1>N° Commande: ${commande.orderNumber }</h1>		
					<h1>Adresse de livraison: ${client.addressLine1 }
						${client.postalCode} ${client.city} ${client.country }</h1>
					<H2>
						Commande du :
						<fmt:formatDate value="${today}" />
					</H2>
					<br />

					<h2>Votre commande a bien été prise en compte</h2>
					<h2>Elle sera traitée dans les plus brefs délais</h2>


				</article>

			</section>



			

	
		<footer> </footer>

</body>
</html>