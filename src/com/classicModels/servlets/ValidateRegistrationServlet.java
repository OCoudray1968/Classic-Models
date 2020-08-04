package com.classicModels.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.classicModels.DTO.CustomersDTO;
import com.classicModels.DTO.LoginsDTO;
import com.classicModels.managers.CustomersManager;
import com.classicModels.managers.LoginsManager;
import com.classicModels.managers.ManagerFactory;

/**
 * Servlet implementation class ValidateUpdateCustomersServlet
 */
@WebServlet("/validateRegistrationServlet")
public class ValidateRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/validerInscription.jsp";
	public static final String VUE1 = "/WEB-INF/validerInscription.jsp";
	public static final String ATT_REGISTRATION = "registrations";

	private long customerNumber;
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
	private String salesRep = " ";
	private String creditLimit = " ";
	private String login = "";
	private String pwd = "";
	Integer profil = 4;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// this.getServletContext().getRequestDispatcher( VUE).forward( request,
		// response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CustomersDTO dernierclient = ManagerFactory.getCustomers();
		dernierclient = (CustomersDTO) CustomersManager.getLast(dernierclient);

		CustomersDTO client = ManagerFactory.getCustomers();
		// incrémentationdu numero client
		customerNumber = dernierclient.getCustomerNumber() + 1;

		client.setCustomerNumber(customerNumber);

		// repération des données rentrées et envoi dans le DTO
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
		salesRep = request.getParameter("salesrep");
		client.setSalesRepEmployeeNumber(Long.parseLong(salesRep));
		creditLimit = request.getParameter("creditlimit");
		client.setCreditLimit(Double.parseDouble(creditLimit));

		LoginsDTO logins = ManagerFactory.getlogins();
		logins.setCustomerNumber(customerNumber);
		login = request.getParameter("login");
		logins.setLogin(login);
		pwd = request.getParameter("pwd");
		logins.setPasswordLogin(pwd);

		logins.setProfil(profil);
		// enregistrement des données

		LoginsManager.setRecord(logins);

		CustomersManager.setRecord(client);

		this.getServletContext().getRequestDispatcher(VUE1).forward(request, response);
	}

}
