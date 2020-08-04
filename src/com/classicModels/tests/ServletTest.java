package com.classicModels.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.classicModels.DTO.LoginsDTO;
import com.classicModels.forms.ConnectionForms;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.servlets.DispatchServlet;

@RunWith(MockitoJUnitRunner.class)
public class ServletTest extends Mockito {

	public ServletTest() {
	}

	private DispatchServlet servlet = new DispatchServlet();
	private ConnectionForms form = new ConnectionForms();

	private HttpServletRequest request = mock(HttpServletRequest.class);
	private HttpServletResponse response = mock(HttpServletResponse.class);
	private HttpSession session = mock(HttpSession.class);

	@ParameterizedTest(name = "login doit etre egal à {0}")
	@CsvSource({ "CARINE,SCHMITT,4", "CRUSTILA,DROCULAN,2" })
	public void testlogin(String login, String password, Integer profil) {
		LoginsDTO user = ManagerFactory.getlogins();
		user.setLogin(login);
		user.setPasswordLogin(password);
		user = (LoginsDTO) LoginsManager.getRecord(user);
		assertEquals(profil, user.getProfil());

	}

	@Test
	public void dispatch() throws ServletException, IOException {
		System.out.println("la requète est :" + request);

		form.verificationLogin(request);

	}

}
