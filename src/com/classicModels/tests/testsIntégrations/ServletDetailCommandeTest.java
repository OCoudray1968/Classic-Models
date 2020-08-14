package com.classicModels.tests.testsIntégrations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.DetailCommandesEnCours;

public class ServletDetailCommandeTest extends Mockito {

	public static final String ATT_EMPLOYEE = "employee";
	public static final String ATT_CUSTOMER = "client";
	public static final String ATT_COMMANDE = "commandes";
	public static final String ATT_DETAIL_COMMANDE = "detailcommandes";
	public static final String VUE = "/WEB-INF/ligneCommandeEnCours.jsp";
	public static final String VUE1 = "/WEB-INF/validationCommandeEnCours.jsp";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test du detail d'une commande")
	@Test
	public void detailCommande() throws Exception {

		when(request.getParameter("orderNumber")).thenReturn("10426");
		when(request.getParameter("customerNumber")).thenReturn("121");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("ATT_DETAIL_COMMANDE")).thenReturn("detailcommandes");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new DetailCommandesEnCours().doPost(request, response);

		verify(request, atLeast(1)).getParameter("orderNumber");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}
