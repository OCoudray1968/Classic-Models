package com.classicModels.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





public class CreationCommandeServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ATT_COMMANDE      = "commande";
    public static final String ATT_FORM          = "form";
    public static final String SESSION_CLIENTS   = "clients";
    public static final String SESSION_COMMANDES = "commandes";

    public static final String VUE_SUCCES        = "/WEB-INF/afficherCommande.jsp";
    public static final String VUE_FORM          = "/WEB-INF/creerCommande.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
        this.getServletContext().getRequestDispatcher( VUE_FORM ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
     
   }
}