package com.classicModels.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classicModels.DTO.RegistrationDTO;
import com.classicModels.managers.ManagerFactory;
import com.classicModels.managers.RegistrationManager;

public class InscriptionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String ATT_SALESREP = "salesrep";
	public static final String ATT_EMPLOYEE = "employees";
	public static final String ATT_FORM = "form";
	public static final String SESSION_CLIENTS = "clients";

	public static final String VUE = "/WEB-INF/inscription.jsp";

	private String customerName = " ";
	private String contactFirstName = " ";
	private String contactLastName = " ";
	private String phone = " ";
	private String addresse1 = " ";
	private String addresse2 = " ";
	private String city = " ";
	private String state = " ";
	private String country = " ";
	private String postalCode = " ";
	private String login = " ";
	private String pwd = " ";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* À la réception d'une requête GET, simple affichage du formulaire */

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RegistrationDTO dernierclient = ManagerFactory.getRegistration();
		dernierclient = (RegistrationDTO) RegistrationManager.getLast(dernierclient);
		System.out.println("dernier client" + dernierclient);
		RegistrationDTO client = ManagerFactory.getRegistration();

		client.setCustomerNumber(dernierclient.getCustomerNumber() + 1);
		customerName = request.getParameter("customername");
		client.setCustomerName(customerName);
		contactFirstName = request.getParameter("contactfirstname");
		client.setContactFirstName(contactFirstName);
		contactLastName = request.getParameter("contactlastname");
		client.setContactLastName(contactLastName);
		phone = request.getParameter("phone");
		client.setPhone(phone);
		addresse1 = request.getParameter("addressline1");
		client.setAddressLine1(addresse1);
		addresse2 = request.getParameter("addressline2");
		client.setAddressLine2(addresse2);
		postalCode = request.getParameter("postalcode");
		client.setPostalCode(postalCode);
		city = request.getParameter("city");
		client.setCity(city);
		state = request.getParameter("state");
		client.setState(state);
		country = request.getParameter("country");
		client.setCountry(country);
		login = request.getParameter("login");
		client.setLogin(login);
		pwd = request.getParameter("pwd");
		client.setPwd(pwd);

		System.out.println("client apres:" + client);

		RegistrationManager.setRecord(client);

		request.getRequestDispatcher(VUE).forward(request, response);

	}
}
