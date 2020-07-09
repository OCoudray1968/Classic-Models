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
					<h1>
						Validation bon de commande
					</h1>
					<p>
						<c:out
							value="${sessionScope.client.contactFirstName} ${client.contactLastName}" />
					</p>
					<img
						src="inc/images/Customers/${client.contactFirstName} ${client.contactLastName}.jpg"
						width=80px height=80px><br>
				</div>

			</div>

			<nav>
				<ul>
					<li><a href="<c:url value="/deconnexionServlet" />">Deconnexion</a></li>


				</ul>
			</nav>

		</header>

		<div id="banniere_image">
			<div id="banniere_description"></div>
		</div>
		<form method="post" action="<c:url value="/dispatchServlet" />">
			<section>
				<article>



					<h1>
						<img src="inc/images/ico_epingle.png" alt="Catégorie"
							class="ico_categorie" />${sessionScope.client.customerName }</h1>
							<a href="<c:url value="/pdfexportFacture"/>">Facture en PDF</a>
					<h1>Adresse de livraison: ${client.addressLine1 }
						${client.postalCode} ${client.city} ${client.country }</h1>
					<H2>
						Commande du :
						<fmt:formatDate value="${today}" />
					</H2>
					<br />

					<h2>La commande a bien été enregistré et va être expédié</h2>
					


				</article>

			</section>



			<input type="submit" value="Retour à la page Client" />

		</form>
		<footer> </footer>
	</div>
</body>
</html>