package com.classicModels.tests.testsIntégrations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.ValidateDeleteOfficeServlet;

public class ServletDeleteOfficeTest extends Mockito {
	public static final String ATT_OFFICE = "offices";
	public static final String ATT_EMPLOYEE = "employee";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/menuOffices.jsp";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de suppression d'une Agence")
	@Test
	public void supprimerUneAgence() throws Exception {

		when(request.getParameter("officecode")).thenReturn("9");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute(ATT_FORM)).thenReturn("form");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new ValidateDeleteOfficeServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("officecode");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}
