package com.classicModels.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import com.classicModels.DTO.LoginsDTO;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.servlets.DispatchServlet;

public class ServletDispatchTest extends Mockito {

	public static final String VUE = "/WEB-INF/connexion.jsp";
	public static final String VUE_EMPLOYE = "/WEB-INF/headerEmployee.jsp";
	public static final String VUE_CLIENT = "/WEB-INF/headerCustomer.jsp";
	public static final String VUE_ADMIN = "/WEB-INF/headerAdmin.jsp";

	HttpServletRequest request = mock(HttpServletRequest.class);
	HttpServletResponse response = mock(HttpServletResponse.class);
	RequestDispatcher dispatcher = mock(RequestDispatcher.class);
	ServletContext context = mock(ServletContext.class);
	HttpSession session = mock(HttpSession.class);

	@DisplayName("Test de la servlet Dispatch pour l'admin")
	@Test

	public void dispatchAdmin() throws Exception {

		when(request.getParameter("utilisateur")).thenReturn("OLIVIER");
		when(request.getParameter("password")).thenReturn("livi1968");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("employee")).thenReturn("admin");

		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE_ADMIN)).thenReturn(dispatcher);

		new DispatchServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("utilisateur");
		verify(request, times(1)).getRequestDispatcher(VUE_ADMIN);
		verify(dispatcher).forward(request, response);
	}

	// meme chose pour un employe
	@DisplayName("Test servleTest dispatch pour les employés")
	@Test

	public void dispatchEmploye() throws Exception {

		when(request.getParameter("utilisateur")).thenReturn("CRUSTILA");
		when(request.getParameter("password")).thenReturn("DROCULAN");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("employee")).thenReturn("employee");

		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE_EMPLOYE)).thenReturn(dispatcher);

		new DispatchServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("utilisateur");
		verify(request, times(1)).getRequestDispatcher(VUE_EMPLOYE);
		verify(dispatcher).forward(request, response);

	}

	@DisplayName("Test servleTest dispatch pour les clients")
	@Test

	public void dispatchClient() throws Exception {

		when(request.getParameter("utilisateur")).thenReturn("CARINE");
		when(request.getParameter("password")).thenReturn("SCHMITT");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("client")).thenReturn("client");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE_CLIENT)).thenReturn(dispatcher);

		new DispatchServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("utilisateur");
		verify(request, times(1)).getRequestDispatcher(VUE_CLIENT);
		verify(dispatcher).forward(request, response);

	}

	@DisplayName("Test servleTest dispatch identifiant inconnu")
	@Test

	public void dispatchInconnu() throws Exception {

		when(request.getParameter("utilisateur")).thenReturn("test");
		when(request.getParameter("password")).thenReturn("secret");

		when(request.getSession()).thenReturn(session);
		when(request.getSession().getAttribute("client")).thenReturn("client");
		when(request.getServletContext()).thenReturn(context);
		when(request.getRequestDispatcher(VUE)).thenReturn(dispatcher);

		new DispatchServlet().doPost(request, response);

		verify(request, atLeast(1)).getParameter("utilisateur");
		verify(request, times(1)).getRequestDispatcher(VUE);
		verify(dispatcher).forward(request, response);

	}

	@ParameterizedTest(name = "login doit etre egal à {0}")
	@CsvSource({ "CARINE,SCHMITT,4", "CRUSTILA,DROCULAN,2", "OLIVIER,livi1968,1" })
	public void testlogin(String login, String password, Integer profil) {
		LoginsDTO user = ManagerFactory.getlogins();
		user.setLogin(login);
		user.setPasswordLogin(password);
		user = (LoginsDTO) LoginsManager.getRecord(user);
		assertEquals(profil, user.getProfil());

	}

}
