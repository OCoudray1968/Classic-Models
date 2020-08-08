package com.classicModels.tests;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.ValidateRegistrationServlet;

public class ServletValidateRegistrationTest extends Mockito {

	public static final String VUE = "/WEB-INF/validerInscription.jsp";
	public static final String VUE1 = "/WEB-INF/validerInscription.jsp";
	public static final String ATT_REGISTRATION = "registrations";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de validation d'une demande d'inscription")
	@Test
	public void validateRegistration() throws Exception {

		when(request.getParameter("customername")).thenReturn("Delage");
		when(request.getParameter("contactlastname")).thenReturn("Millo");
		when(request.getParameter("contactfirstname")).thenReturn("Nathalie");
		when(request.getParameter("phone")).thenReturn("0493837108");
		when(request.getParameter("addressline1")).thenReturn("168 avenue sainte marguerite");
		when(request.getParameter("addressline2")).thenReturn("");
		when(request.getParameter("city")).thenReturn("Nice");
		when(request.getParameter("state")).thenReturn("");
		when(request.getParameter("postalcode")).thenReturn("06200");
		when(request.getParameter("country")).thenReturn("France");
		when(request.getParameter("salesrep")).thenReturn("1370");
		when(request.getParameter("creditlimit")).thenReturn("42000.00");
		when(request.getParameter("login")).thenReturn("NATHALIE");
		when(request.getParameter("pwd")).thenReturn("DELAGE");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute(ATT_REGISTRATION)).thenReturn("registrations");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new ValidateRegistrationServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("customername");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}
