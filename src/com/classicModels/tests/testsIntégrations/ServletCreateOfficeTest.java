package com.classicModels.tests;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.CreateofficeServlet;

public class ServletCreateOfficeTest extends Mockito {
	public static final String CHEMIN = "chemin";
	public static final String ATT_OFFICES = "offices";
	public static final String ATT_EMPLOYEE = "employees";
	public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/createOffice.jsp";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de creation d'une Agence")
	@Test
	public void creerUneAgence() throws Exception {

		when(request.getParameter("city")).thenReturn("Paris");
		when(request.getParameter("phone")).thenReturn("+33 193837108");
		when(request.getParameter("addressline1")).thenReturn("168 avenue des champs Elysees");
		when(request.getParameter("addressline2")).thenReturn("");
		when(request.getParameter("state")).thenReturn("");
		when(request.getParameter("postalcode")).thenReturn("750000");
		when(request.getParameter("country")).thenReturn("France");
		when(request.getParameter("territory")).thenReturn("France");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute(ATT_FORM)).thenReturn("form");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new CreateofficeServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("city");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}
