package com.classicModels.tests;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.OrdersServlet;

public class ServletOrderTest extends Mockito {

	public static final String ATT_PRODUCTS = "produit";
	public static final String ATT_PANIER = "panier";
	private static String VUE_PANIER = "/WEB-INF/catalogueCommande.jsp";
	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de creation")
	@Test
	public void PasserCommande() throws Exception {

		when(request.getParameter("codeProduit")).thenReturn("S10_1678");
		when(request.getParameter("designation")).thenReturn("'1969 Harley Davidson Ultimate Chopper'");
		when(request.getParameter("quantite")).thenReturn("2");
		when(request.getParameter("prix")).thenReturn("95.70");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("ATT_PANIER")).thenReturn("panier");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE_PANIER)).thenReturn(dispatcher);

		new OrdersServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("codeProduit");
		verify(request, times(1)).getRequestDispatcher(VUE_PANIER);
		verify(dispatcher).forward(request, response);
	}

}
