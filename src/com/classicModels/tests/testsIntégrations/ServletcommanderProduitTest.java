package com.classicModels.tests.testsIntégrations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.ListProductCommandeServlet;

public class ServletcommanderProduitTest extends Mockito {

	public static final String ATT_PRODUCTLINES = "productline";
	public static final String ATT_PRODUCTS = "produit";
	public static final String ATT_PANIER = "panier";
	public static final String ATT_INDEX = "lignePanier";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/catalogueCommande.jsp";
	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de commande de produit")
	@Test
	public void commanderProduit() throws Exception {

		when(request.getParameter("codeProduit")).thenReturn("S10_1678");
		when(request.getParameter("designation")).thenReturn("'1969 Harley Davidson Ultimate Chopper'");
		when(request.getParameter("quantite")).thenReturn("2");
		when(request.getParameter("prix")).thenReturn("95.70");
		when(request.getParameter("index")).thenReturn("0");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("ATT_DETAIL_COMMANDE")).thenReturn("detailcommandes");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new ListProductCommandeServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("codeProduit");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);

	}

}
