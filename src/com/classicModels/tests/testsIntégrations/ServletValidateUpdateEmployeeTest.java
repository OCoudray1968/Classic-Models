package com.classicModels.tests.testsIntégrations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.ValidateUpdateEmployeeServlet;

public class ServletValidateUpdateEmployeeTest extends Mockito {

	public static final String VUE = "/WEB-INF/menuEmployees.jsp";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de creation d'un employé")
	@Test
	public void creerUnEmploye() throws Exception {
		when(request.getParameter("employeenumber")).thenReturn("1714");
		when(request.getParameter("lastname")).thenReturn("Gatt");
		when(request.getParameter("firstname")).thenReturn("Christian");
		when(request.getParameter("extension")).thenReturn("X3009");
		when(request.getParameter("email")).thenReturn("cGatt@classicmodelcars.com");
		when(request.getParameter("officecode")).thenReturn("1");
		when(request.getParameter("reportsto")).thenReturn("1002");
		when(request.getParameter("jobtitle")).thenReturn("Sales Rep");
		when(request.getParameter("login")).thenReturn("CHRISTIAN");
		when(request.getParameter("pwd")).thenReturn("GATT");
		when(request.getParameter("profil")).thenReturn("2");

		when(request.getSession()).thenReturn(session);
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new ValidateUpdateEmployeeServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("firstname");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}