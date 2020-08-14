package com.classicModels.tests.testsIntégrations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.InscriptionServlet;

public class ServletInscriptionTest extends Mockito {

	public static final String ATT_SALESREP = "salesrep";
	public static final String ATT_EMPLOYEE = "employees";
	public static final String ATT_FORM = "form";
	public static final String SESSION_CLIENTS = "clients";

	public static final String VUE = "/WEB-INF/inscription.jsp";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test d'inscription")
	@Test
	public void inscription() throws Exception {

		when(request.getParameter("customername")).thenReturn("Altaya");
		when(request.getParameter("contactlastname")).thenReturn("Nael");
		when(request.getParameter("contactfirstname")).thenReturn("Madeleine");
		when(request.getParameter("phone")).thenReturn("0293837108");
		when(request.getParameter("addressline1")).thenReturn("168 avenue sainte marguerite");
		when(request.getParameter("addressline2")).thenReturn("");
		when(request.getParameter("city")).thenReturn("Malestroit");
		when(request.getParameter("state")).thenReturn("");
		when(request.getParameter("postalcode")).thenReturn("56800");
		when(request.getParameter("country")).thenReturn("France");

		when(request.getParameter("login")).thenReturn("MADELEINE");
		when(request.getParameter("pwd")).thenReturn("NAEL");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute(ATT_FORM)).thenReturn("form");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new InscriptionServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("customername");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}
