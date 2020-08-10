package com.classicModels.tests;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.ValiderPrepaCommande;

public class ServletValiderPrepaCommandeTest extends Mockito {
	private static final long serialVersionUID = 1L;
	public static final String ATT_EMPLOYEE = "employee";
	public static final String ATT_CUSTOMER = "client";
	public static final String ATT_COMMANDE = "commandes";
	public static final String ATT_DETAIL_COMMANDE = "detailcommandes";

	public static final String VUE = "/WEB-INF/validationCommandeEnCours.jsp";
	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de validation d'une prepa commande")
	@Test
	public void validerPrepaCommande() throws Exception {

		when(request.getParameter("codeProduit")).thenReturn("S10_1678");
		when(request.getParameter("designation")).thenReturn("'1969 Harley Davidson Ultimate Chopper'");
		when(request.getParameter("quantite")).thenReturn("2");
		when(request.getParameter("prix")).thenReturn("95.70");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("ATT_DETAIL_COMMANDE")).thenReturn("detailcommandes");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new ValiderPrepaCommande().doPost(request, response);

		verify(request, atLeast(1)).getParameter("codeProduit");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}
