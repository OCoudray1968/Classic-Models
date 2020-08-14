package com.classicModels.tests.testsIntégrations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.classicModels.servlets.CreateProductServlet;

public class ServletCreateProductTest extends Mockito {

	public static final String ATT_PRODUCTLINE = "productline";
	public static final String VUE = "/WEB-INF/createProduct.jsp";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de creation d'un produit")
	@Test
	public void creerUnProduit() throws Exception {

		when(request.getParameter("productcode")).thenReturn("S10_999");
		when(request.getParameter("productname")).thenReturn("2018 CBR 1000 Honda Repsol Edition");
		when(request.getParameter("productline")).thenReturn("Motorcycle");
		when(request.getParameter("productscale")).thenReturn("1:10");
		when(request.getParameter("productvendor")).thenReturn("Motor city Art Classics");
		when(request.getParameter("productdescription")).thenReturn("Motor features, official Honda Repsol Logo");
		when(request.getParameter("quantityinstock")).thenReturn("8000");
		when(request.getParameter("buyprice")).thenReturn("95.00");
		when(request.getParameter("msrp")).thenReturn("200.00");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute(ATT_PRODUCTLINE)).thenReturn("productline");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new CreateProductServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("productname");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);
	}

}
