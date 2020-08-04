<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Classic Model Accueil</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="css/main.css" />
    
</head>


<div id="accueil">
    <header>
        <div id="titre_principal">
            <div id="logo">
                <img src="images/logoCM.png" alt="Logo de Classic Models" />
                <h1>Accueil</h1>
            </div>

        </div>
	<!--  affichage du menu d'acueil -->
        <nav>
            <ul>
              	 <li><a href="<c:url value="/connexionServlet" />">Connexion</a></li>
                 <li><a href="<c:url value="/inscriptionServlet" />">Inscription</a></li>
            </ul>
        </nav>
    </header>
</div>
<body>
  
		 <section>
			<!--  affichage du carousel des categories de produits -->
		
            <div class="container">
                              
                <div id="carousel1">
                    <div class="item">
                        <div class="item__image" >
                         <a
							 href="<c:url value="/listProductServlet"><c:param name="productline" value="Classic Cars"/></c:url>">
						
                            <img src="images/Products/S10_4962.jpg" alt="Voiture">
                            </a>
                        </div>
                        <div class="item__body">
                            <div class="item__title">
                                Voitures
                            </div>
                            <div class="item__description">
                                Classic Cars 
                            </div>
                        </div>
                        </div>
                    <div class="item">
                        <div class="item__image">
                         <a  href="<c:url value="/listProductServlet"><c:param name="productline" value="Motorcycles" /></c:url>">
                            <img src="images/Products/S12_2823.jpg" alt="Moto">
                         </a>
                        </div>
                        <div class="item__body">
                            <div class="item__title">
                                Motos
                            </div>
                            <div class="item__description">
                                MotorCycles
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="item__image">
                        	<a  href="<c:url value="/listProductServlet"><c:param name="productline" value="Vintage Cars" /></c:url>">
                           	 <img src="images/Products/S24_3420.jpg" alt="Voiture ancienne">
                            </a>
                        </div>
                        <div class="item__body">
                            <div class="item__title">
                                Voitures
                            </div>
                            <div class="item__description">
                               Vintage Cars
                            </div>
                        </div>
                        </div>
                    <div class="item">
                        <div class="item__image">
	                        <a href="<c:url value="/listProductServlet"><c:param name="productline" value="Planes" /></c:url>">
	                            <img src="images/Products/S24_3949.jpg" alt="Avion">
	                        </a>
                        </div>
                        <div class="item__body">
                            <div class="item__title">
                                Avions
                            </div>
                            <div class="item__description">
                                Planes
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="item__image">
	                        <a href="<c:url value="/listProductServlet"><c:param name="productline" value="Ships" /></c:url>">
	                          <img src="images/Products/S700_2047.jpg" alt="Bateau">
	                        </a>
                        </div>
                        <div class="item__body">
                            <div class="item__title">
                                Bateaux
                            </div>
                            <div class="item__description">
                                Ships
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="item__image">
                        	<a href="<c:url value="/listProductServlet"><c:param name="productline" value="Trains" /></c:url>">
                           	 <img src="images/Products/S18_3259.jpg" alt="Train">
                            </a>
                        </div>
                        <div class="item__body">
                            <div class="item__title">
                                Trains
                            </div>
                            <div class="item__description">
                                Trains
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <div class="item__image">
                         	<a href="<c:url value="/listProductServlet"><c:param name="productline" value="Trucks and Buses" /></c:url>">
                            	<img src="images/Products/S32_2509.jpg" alt="Bus">
                            </a>
                        </div>
                        <div class="item__body">
                            <div class="item__title">
                                Bus et Camions
                            </div>
                            <div class="item__description">
                                Truck and Buses
                            </div>
                        </div>
                    </div>
                </div>
               
        
           </div>
            <!--  affichage de la fenêtre d'information -->
          
			<aside>
				<h1>BIENVENUE <br>CHEZ <br>CLASSIC MODELS</h1>
				<ul>
				    <li>Notre société leader dans la vente de  Modèles réduits de qualités vous propose un choix multiple d'une très grande précision
                            de reproduction.</li>
                   
				    <li><img src="images/banniere.jpeg" alt="logo classic model"  width=300 height=200 ></li>
				</ul>
				
			</aside>
        </section>
        <!--  préparation des fenêtre modales -->
        <aside id="cgv" class="modal" aria-hidden="true" role="dialog" aria-labelledby="titlemodal" style="display:none;">
            <div class="modal-wrapper js-modal-stop">
                
    
                <h1 id="titlemodal">Conditions Générales de Vente</h1>

                <p>Entre la société  Classic Model
                    153 Route de Turin, 06000 NICE
                    au Capital Social de 500.000€,
                    immatriculée au Registre du Commerce et des Sociétés de NICE,
                    sous le numéro SIRET 123456789,
                    représentée par M. Olivier Coudray
                    en qualité de gérant,
                    dûment habilité aux fins des présentes.
                    La société peut être jointe par email en cliquant sur le formulaire de contact accessible via la page
                    d’accueil du site.
                    Ci-après le « Vendeur » ou la « Société ».
                    D’une part,
                    Et la personne physique ou morale procédant à l’achat de produits ou services de la société,
                    Ci-après, « l’Acheteur », ou « le Client »
                    D’autre part,
                    Il a été exposé et convenu ce qui suit :
                <h1 id="titlemodal"> Préambule</h1>
                <p>Le Vendeur est éditeur de Produits à destination de consommateurs,
                    commercialisés par l’intermédiaire de ses sites Internet (http://www.classicModel.com ). La liste et le
                    descriptif des biens et services proposés par la Société peuvent être consultés sur les sites
                    susmentionnés.
                </p>                    
                
                <p><strong>1 : Objet</strong> <br>
                    Les présentes Conditions Générales de Vente déterminent les droits et obligations des parties
                    dans le cadre de la vente en ligne de Produits ou Services proposés par le Vendeur.
                </p>    
                   
                <p><strong> 2 : Dispositions générales</strong>
                    Les présentes Conditions Générales de Vente (CGV) régissent les ventes de Produits ou de
                    Services, effectuées au travers des sites Internet de la Société, et sont partie intégrante du
                    Contrat entre l’Acheteur et le Vendeur. Elle sont pleinement opposable à l'Acheteur qui les a
                    accepté avant de passer commande.
                    Le Vendeur se réserve la possibilité de modifier les présentes, à tout moment par la publication
                    d’une nouvelle version sur son site Internet. Les CGV applicables alors sont celles étant en
                    vigueur à la date du paiement (ou du premier paiement en cas de paiements multiples) de la
                    commande. Ces CGV sont consultables sur le site Internet de la Société à l'adresse suivante :
                    La Société s’assure également que leur acceptation soit claire et sans réserve en mettant en
                    place une case à cocher et un clic de validation. Le Client déclare avoir pris connaissance de
                    l’ensemble des présentes Conditions Générales de Vente, et le cas échéant des Conditions
                    Particulières de Vente liées à un produit ou à un service, et les accepter sans restriction ni réserve.
                    Le Client reconnaît qu’il a bénéficié des conseils et informations nécessaires afin de s’assurer de
                    l’adéquation de l’offre à ses besoins.
                    Le Client déclare être en mesure de contracter légalement en vertu des lois françaises ou
                    valablement représenter la personne physique ou morale pour laquelle il s’engage.
                    Sauf preuve contraire les informations enregistrées par la Société constituent la preuve de
                    l’ensemble des transactions.
                <p><strong>Article 3 : Prix</strong><br>
                    Les prix des produits vendus au travers des sites Internet sont indiqués en Euros hors taxes et
                    précisément déterminés sur les pages de descriptifs des Produits. Ils sont également indiqués en
                    euros toutes taxes comprises (TVA + autres taxes éventuelles) sur la page de commande des
                    produits, et hors frais spécifiques d'expédition. Pour tous les produits expédiés hors Union
                    européenne et/ou DOM-TOM, le prix est calculé hors taxes automatiquement sur la facture. Des
                    droits de douane ou autres taxes locales ou droits d'importation ou taxes d'état sont susceptibles
                    d'être exigibles dans certains cas. Ces droits et sommes ne relèvent pas du ressort du Vendeur.
                    Ils seront à la charge de l'acheteur et relèvent de sa responsabilité (déclarations, paiement aux
                    autorités compétentes, etc.). Le Vendeur invite à ce titre l'acheteur à se renseigner sur ces
                    aspects auprès des autorités locales correspondantes.La Société se réserve la possibilité de
                    modifier ses prix à tout moment pour l’avenir. Les frais de télécommunication nécessaires à
                    l’accès aux sites Internet de la Société sont à la charge du Client. Le cas échéant également, les
                    frais de livraison.
                    
                <p><strong> 4 : Conclusion du contrat en ligne</strong><br>
                    Conformément aux dispositions de l'article 1127-1 du Code civil, le Client doit suivre une série
                    d’étapes pour conclure le contrat par voie électronique pour pouvoir réaliser sa commande :;
                    Information sur les caractéristiques essentielles du Produit ;
                    <ol>
                        <li> Choix du Produit, le cas
                            échéant, de ses options - Indication des coordonnées essentielles du Client (identification, email,
                            adresse…) </li>
                        <li> Acceptation des présentes Conditions Générales de Vente</li>
                        <li> Vérification des éléments de la commande (formalité du double clic) et, le cas échéant, correction
                            des erreurs. Avant de procéder à sa confirmation, l'Acheteur a la possibilité de vérifier le détail de
                            sa commande, son prix, et de corriger ses éventuelles erreur, ou annuler sa commande. La
                            confirmation de la commande emportera formation du présent contrat.</li>
                            
                    </ol>
                <p> Ensuite, suivi des instructions pour le paiement, paiement des produits, puis livraison de la commande. Le Client
                    recevra confirmation par courrier électronique du paiement de la commande, ainsi qu’un accusé
                    de réception de la commande la confirmant. Il recevra un exemplaire .pdf des présentes
                    conditions générales de vente.
                    Le client disposera pendant son processus de commande de la possibilité d'identifier
                    d'éventuelles erreurs commises dans la saisie des données et de les corriger. La langue proposé
                    pour la conclusion du contrat est la langue française.
                    Les modalités de l'offre et des conditions générales de vente sont renvoyées par email à
                    l'acheteur lors de la commande et archivées sur le site web du Vendeur. Le cas échéant, les
                    règles professionnelles et commerciales auxquelles l'auteur de l'offre entend se soumettre sont
                    consultables dans la rubrique "règles annexes" des présentes CGV, consultables sur le site du
                    Vendeur à l'adresse suivante :www.classicModel.com
                    L'archivage des communications, de la commande, des détails de la commande, ainsi que des
                    factures est effectué sur un support fiable et durable de manière constituer une copie fidèle et
                    durable conformément aux dispositions de l'article 1360 du code civil. Ces informations peuvent
                    être produits à titre de preuve du contrat.
                    Pour les produits livrés, la livraison se fera à l’adresse indiquée par le Client. Aux fins de bonne
                    réalisation de la commande, le Client s’engage à fournir ses éléments d’identification véridiques.
                    Le Vendeur se réserve la possibilité de refuser la commande, par exemple pour toute demande
                    anormale, réalisée de mauvaise foi ou pour tout motif légitime.
                <p><strong>  Article 5 : Produits et services</strong><br>
                    Les caractéristiques essentielles des biens, des services et leurs prix respectifs sont mis à
                    disposition de l’acheteur sur les sites Internet de la société, de même, le cas échéant, que le
                    mode d'utilisation du produit. Conformément à l'article L112-1 du Code la consommation, le
                    consommateur est informé, par voie de marquage, d'étiquetage, d'affichage ou par tout autre
                    procédé approprié, des prix et des conditions particulières de la vente et de l'exécution des
                    services avant toute conclusion du contrat de vente. Dans tous les cas, le montant total dû par
                    l'Acheteur est indiqué sur la page de confirmation de la commande. Le prix de vente du produit
                    est celui en vigueur indiqué au jour de la commande, celui-ci ne comportant par les frais de ports
                    facturés en supplément. Ces éventuels frais sont indiqués à l'Achteur lors du process de vente, et
                    en tout état de cause au moment de la confirmation de la commande. Le Vendeur se réserve la
                    possibilité de modifier ses prix à tout moment, tout en garantissant l'application du prix indiqué
                    au moment de la commande.
                    Lorsque les produits ou services ne sont pas exécuté immédiatement, une information claire est
                    donnée sur la page de présentation du produit quant aux dates de livraison des produits ou
                    services. Le client atteste avoir reçu un détail des frais de livraison ainsi que les modalités de
                    paiement, de livraison et d’exécution du contrat, ainsi qu'une information détaillée relative à
                    l'identité du vendeur, ses coordonnées postales, téléphoniques et électroniques, et à ses activités
                    dans le contexte de la présente vente. Le Vendeur s’engage à honorer la commande du Client
                    dans la limite des stocks de Produits disponibles uniquement. A défaut, le Vendeur en informe le
                    Client ; si la commande a été passée, et à défaut d'accord avec le Client sur une nouvelle date de
                    livraison, le Vendeur rembourse le client.
                    Les informations contractuelles sont présentées en détail et en langue française. Les parties
                    conviennent que les illustrations ou photos des produits offerts à la vente n’ont pas de valeur
                    contractuelle. La durée de validité de l’offre des Produits ainsi que leurs prix est précisée sur les
                    sites Internet de la Société, ainsi que la durée minimale des contrats proposés lorsque ceux-ci
                    portent sur une fourniture continue ou périodique de produits ou services. Sauf conditions
                    particulières, les droits concédés au titre des présentes le sont uniquement à la personne
                    physique signataire de la commande (ou la personne titulaire de l’adresse email communiqué).
                <p><strong>Article 6 : Conformité</strong><br>
                    Conformément à l'article L.411-1 du Code de la consommation, les produits et les services offert
                    à la vente au travers des présentes CGV répondent aux prescriptions en vigueur relatives à la
                    sécurité et à la santé des personnes, à la loyauté des transactions commerciales et à la protection
                    des consommateurs. Indépendamment de toute garantie commerciale, le Vendeur reste tenu des
                    défauts de conformité et des vices cachés du produit.
                    Conformément à l'article L.217-4, le vendeur livre un bien conforme au contrat et répond des
                    défauts de conformité existant lors de la délivrance. Il répond également des défauts de
                    conformité résultant de l'emballage, des instructions de montage ou de l'installation lorsque celleci
                    a été mise à sa charge par le contrat ou a été réalisée sous sa responsabilité.
                    Conformément aux dispositions légales en matière de conformité et de vices cachés (art. 1641 c.
                    civ.), le Vendeur rembourse ou échange les produits défectueux ou ne correspondant pas à la
                    commande. Le remboursement peut être demandé de la manière suivante : ________ (décrire la
                    procédure de remboursement, et comment le produit doit être retourné, et le remboursement des
                    frais d'expédition le cas échéant).
                    
                    <button class="js-modal-close">Fermer les CGV</button>
              
                  </div>
    
        </aside>
        
       <aside id="sc" class="modal" aria-hidden="true" role="dialog" aria-labelledby="titlemodal" style="display:none;">
            <div class="modal-wrapper js-modal-stop">
                <button class="js-modal-close">Fermer</button>
    
                <h1 id="titlemodal">Service Client</h1>

              	<p>
               	Nom du Responsable: Mr Falconnetti Jean-louis
               	<br/>
               	Tel: 04 92 18 67 00
               	<br/>
               	Mail: JLFaconnetti@classicModels.com
               	<br>
               	</p>
               	<form method="post" action="mailto:JLFaconnetti@classicModels.com">
               	<button type=submit>Contacter le Service Client</button>
               	</form>
              
             </div>
    
        </aside>
        
  

</body>

    <footer>
		
		    <nav>
				<ul>
					<li><a href="#cgv" class="js-modal">Conditions Générales de Vente</a></li>
					<li><a href="#sc" class="js-modal">Service Client</a></li>
					
			

				</ul>
		    </nav>
		
    </footer>
    <!--  appel du Javascript principal -->
    <script src="js/main.js"  ></script>
</html>