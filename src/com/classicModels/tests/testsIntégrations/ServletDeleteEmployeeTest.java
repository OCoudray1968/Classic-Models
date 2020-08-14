package com.classicModels.tests.testsIntégrations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.ValidateDeleteEmployeeServlet;

public class ServletDeleteEmployeeTest extends Mockito {

	public static final String ATT_EMPLOYEES = "employees";
	public static final String ATT_EMPLOYEE = "employee";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/menuEmployees.jsp";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de suppression d'un employé")
	@Test
	public void supprimerUnEmploye() throws Exception {

		when(request.getParameter("EmployeeNumber")).thenReturn("1714");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute(ATT_EMPLOYEES)).thenReturn("employees");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new ValidateDeleteEmployeeServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("EmployeeNumber");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}