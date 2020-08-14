package com.classicModels.tests.testsIntégrations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.ListeCommandesServlet;

public class ServletListecommandeTest extends Mockito {

	public static final String ATT_LOGIN = "utilisateur";
	public static final String ATT_CUSTOMER = "client";
	public static final String ATT_COMMANDE = "commandes";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/listerCommandes.jsp";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test du detail d'une commande")
	@Test
	public void detailCommande() throws Exception {
		session.setAttribute(ATT_CUSTOMER, "121");
		when(request.getParameter(ATT_CUSTOMER)).thenReturn("121");
		when(request.getSession()).thenReturn(session);
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new ListeCommandesServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter(ATT_CUSTOMER);
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}
