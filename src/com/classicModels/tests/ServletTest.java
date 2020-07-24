package com.classicModels.tests;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.DispatchServlet;

public class ServletTest extends Mockito {

	private DispatchServlet servlet = new DispatchServlet();

	private HttpServletRequest request = mock(HttpServletRequest.class);
	private HttpServletResponse response = mock(HttpServletResponse.class);
	private HttpSession session = mock(HttpSession.class);

	@Test
	public void dispatch() throws ServletException, IOException {

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("OLIVIER")).thenReturn("Admin");

		servlet.doPost(request, response);
	}

}
